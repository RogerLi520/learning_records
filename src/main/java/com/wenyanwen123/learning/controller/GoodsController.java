package com.wenyanwen123.learning.controller;

import com.alibaba.fastjson.JSON;
import com.wenyanwen123.learning.commons.core.BaseController;
import com.wenyanwen123.learning.commons.domain.models.goods.RushToBuyRp;
import com.wenyanwen123.learning.commons.response.ResultResponse;
import com.wenyanwen123.learning.commons.util.LogUtil;
import com.wenyanwen123.learning.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 商品
 * @Author liww
 * @Date 2020/2/6
 * @Version 1.0
 */
@Api(value = "商品")
@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;

    @ApiOperation(value = "抢购")
    @ApiResponse(code = 200, message = "ok", response = ResultResponse.class, responseContainer = "List")
    @PostMapping("/rush")
    public ResultResponse rushToBuy(@RequestBody RushToBuyRp param) {
        LogUtil.callStart(log, "抢购", param.getUserId());
        log.info("参数，param：{}", JSON.toJSONString(param));
        ResultResponse resultResponse = goodsService.rushToBuy(param);
        LogUtil.outputResult(log, resultResponse);
        return resultResponse;
    }

}
