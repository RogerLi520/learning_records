package com.wenyanwen123.learning.service;

import com.wenyanwen123.learning.commons.domain.models.goods.RushToBuyRp;
import com.wenyanwen123.learning.commons.response.ResultResponse;

/**
 * @Desc 商品
 * @Author liww
 * @Date 2020/2/6
 * @Version 1.0
 */
public interface GoodsService {

    /**
     * @Desc 抢购
     * @Author liww
     * @Date 2020/2/6
     * @Param [param]
     * @return com.wenyanwen123.learning.commons.response.ResultResponse
     */
    ResultResponse rushToBuy(RushToBuyRp param);

}
