package com.wenyanwen123.learning.service.impl;

import com.wenyanwen123.learning.commons.domain.models.thread.RunThreadRp;
import com.wenyanwen123.learning.commons.response.ResultResponse;
import com.wenyanwen123.learning.commons.util.LogUtil;
import com.wenyanwen123.learning.service.MultithreadingService;
import com.wenyanwen123.learning.thread.RushToBuyThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 启动多线程
 * @Author liww
 * @Date 2020/2/8
 * @Version 1.0
 */
@Service
public class MultithreadingServiceImpl implements MultithreadingService {

    private static final Logger log = LoggerFactory.getLogger(MultithreadingServiceImpl.class);

    public static final CountDownLatch CDL = new CountDownLatch(100); // 计数数量为100

    /**
     * @Desc 启动多线程
     * @Author liww
     * @Date 2020/2/8
     * @Param [param]
     * @return com.wenyanwen123.learning.commons.response.ResultResponse
     */
    @Override
    public ResultResponse runThread(RunThreadRp param) {
        LogUtil.serviceStart(log, "启动多线程");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < param.getTotal(); i++) {
            Thread thread = new RushToBuyThread();
            thread.start();
        }
        try {
            CDL.await();
        } catch (InterruptedException e) {
            // TODO
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        return ResultResponse.success("执行完毕，耗时：" + totalTime);
    }

}
