package com.wenyanwen123.learning.service;

import com.wenyanwen123.learning.commons.domain.models.thread.RunThreadRp;
import com.wenyanwen123.learning.commons.response.ResultResponse;

/**
 * @Desc 多线程
 * @Author liww
 * @Date 2020/2/8
 * @Version 1.0
 */
public interface MultithreadingService {

    /**
     * @Desc 启动多线程
     * @Author liww
     * @Date 2020/2/8
     * @Param [param]
     * @return com.wenyanwen123.learning.commons.response.ResultResponse
     */
    ResultResponse runThread(RunThreadRp param);

}
