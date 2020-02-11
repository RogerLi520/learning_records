package com.wenyanwen123.learning.thread;

import com.wenyanwen123.learning.commons.config.BeanContext;
import com.wenyanwen123.learning.commons.domain.models.goods.RushToBuyRp;
import com.wenyanwen123.learning.service.GoodsService;
import com.wenyanwen123.learning.service.impl.GoodsServiceImpl;
import com.wenyanwen123.learning.service.impl.MultithreadingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 抢购线程
 * @Author liww
 * @Date 2020/2/8
 * @Version 1.0
 */
public class RushToBuyThread extends Thread {

    private static final Logger log = LoggerFactory.getLogger(RushToBuyThread.class);

    private GoodsService goodsService;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        RushToBuyRp rushToBuyRp = new RushToBuyRp();
        rushToBuyRp.setGoodsId(1);
        rushToBuyRp.setUserId(Thread.currentThread().hashCode());
        rushToBuyRp.setUserName(threadName);
        this.goodsService = BeanContext.getBean("goodsServiceImpl2");
        goodsService.rushToBuy(rushToBuyRp);
        MultithreadingServiceImpl.CDL.countDown();
    }

}
