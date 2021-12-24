package com.sherlockmen.newcoderBlog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {

    private static final Logger logger = LoggerFactory.getLogger(AlphaService.class);

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    @Async//该注解可以让方法使用spring普通线程池调用
    public void execute1(){
        logger.debug("execute1");
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 1000)//该注解可以使方法可以使用spring定时任务线程池调用
    public void execute2(){
        logger.debug("execute2");
    }

}
