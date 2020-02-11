package com.wenyanwen123.learning.controller;

import com.alibaba.fastjson.JSON;
import com.wenyanwen123.learning.commons.domain.models.thread.RunThreadRp;
import com.wenyanwen123.learning.commons.response.ResultResponse;
import com.wenyanwen123.learning.commons.util.LogUtil;
import com.wenyanwen123.learning.service.MultithreadingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author liww
 * @Date 2020/2/8
 * @Version 1.0
 */
@Api(value = "模拟多线程请求")
@RestController
@RequestMapping("/thread")
public class MultithreadingController {

    private static final Logger log = LoggerFactory.getLogger(MultithreadingController.class);

    @Autowired
    private MultithreadingService multithreadingService;

    @ApiOperation(value = "启动多线程")
    @ApiResponse(code = 200, message = "ok", response = ResultResponse.class, responseContainer = "List")
    @PostMapping("/run")
    public ResultResponse runThread(@RequestBody RunThreadRp param) {
        LogUtil.callStart(log, "启动多线程", null);
        log.info("参数，param：{}", JSON.toJSONString(param));
        ResultResponse resultResponse = multithreadingService.runThread(param);
        LogUtil.outputResult(log, resultResponse);
        return resultResponse;
    }

}
