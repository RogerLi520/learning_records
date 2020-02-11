package com.wenyanwen123.learning.service.impl;

import com.wenyanwen123.learning.commons.domain.learningdb.Goods;
import com.wenyanwen123.learning.commons.domain.learningdb.GoodsExample;
import com.wenyanwen123.learning.commons.domain.learningdb.RecordOfGoodsSold;
import com.wenyanwen123.learning.commons.domain.models.goods.RushToBuyRp;
import com.wenyanwen123.learning.commons.response.ResultResponse;
import com.wenyanwen123.learning.commons.util.DateUtil;
import com.wenyanwen123.learning.commons.util.LogUtil;
import com.wenyanwen123.learning.dao.learningdb.GoodsMapper;
import com.wenyanwen123.learning.dao.learningdb.RecordOfGoodsSoldMapper;
import com.wenyanwen123.learning.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 普通实现，不加锁
 * @Author liww
 * @Date 2020/2/6
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RecordOfGoodsSoldMapper recordOfGoodsSoldMapper;

    /**
     * @Desc 抢购
     * @Author liww
     * @Date 2020/2/6
     * @Param [param]
     * @return com.wenyanwen123.learning.commons.response.ResultResponse
     */
    @Override
    public ResultResponse rushToBuy(RushToBuyRp param) {
        LogUtil.serviceStart(log, "抢购");
        int goodsStock = 0;
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.or().andGoodsIdEqualTo(param.getGoodsId());
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        if (goodsList != null && goodsList.size() > 0) {
            Goods goods = goodsList.get(0);
            goodsStock = goods.getGoodsStock();
            log.debug("线程：{}，查询到的商品库存：{}", Thread.currentThread().getName(), goods.getGoodsStock());
            if (goods.getGoodsStock() > 0) {
                // 未抢购完
                // 添加抢购记录
                addPurhcaseResult(param, goodsStock, GoodsStockState.NORMAL);
                // 更新商品库存
                goods.setGoodsStock(goods.getGoodsStock() - 1);
                goods.setTotalSales(goods.getTotalSales() + 1);
                goods.setUpdateTime(DateUtil.getCurrentDate());
                goods.setUpdateDate(DateUtil.getTimeStamp());
                goodsMapper.updateByPrimaryKey(goods);

                return ResultResponse.success("抢购成功");
            } else {
                // 已抢购完
                // 添加抢购记录
                addPurhcaseResult(param, goodsStock, GoodsStockState.EMPTY);
                return ResultResponse.success("商品已售完！");
            }
        } else {
            // 添加抢购记录
            addPurhcaseResult(param, goodsStock, GoodsStockState.END);
            return ResultResponse.success("商品已下架");
        }
    }

    /**
     * @Desc 添加抢购记录
     * @Author liww
     * @Date 2020/2/10
     * @Param [param, goodsStock, result]
     * @return void
     */
    private void addPurhcaseResult(RushToBuyRp param, int goodsStock, int result) {
        RecordOfGoodsSold recordOfGoodsSold = new RecordOfGoodsSold();
        recordOfGoodsSold.setGoodsId(param.getGoodsId());
        recordOfGoodsSold.setUserId(param.getUserId());
        recordOfGoodsSold.setUserName(param.getUserName());
        recordOfGoodsSold.setCurrentStock(goodsStock);
        if (result == GoodsStockState.NORMAL) {
            recordOfGoodsSold.setPurchaseResult(true);
            recordOfGoodsSold.setRemark("抢购成功");
        }
        if (result == GoodsStockState.EMPTY) {
            recordOfGoodsSold.setPurchaseResult(false);
            recordOfGoodsSold.setRemark("商品已售完");
        }
        if (result == GoodsStockState.END) {
            recordOfGoodsSold.setPurchaseResult(false);
            recordOfGoodsSold.setRemark("商品已下架");
        }
        recordOfGoodsSold.setCreateTime(DateUtil.getCurrentDate());
        recordOfGoodsSold.setCreateDate(DateUtil.getTimeStamp());
        recordOfGoodsSold.setIsDelete(false);
        recordOfGoodsSoldMapper.insert(recordOfGoodsSold);
    }

    /**
     * @Desc 商品库存状态
     * @Author liww
     * @Date 2020/2/10
     * @Version 1.0
     */
    interface GoodsStockState {
        int NORMAL = 1;
        int EMPTY = 2;
        int END = 3;
    }

}
