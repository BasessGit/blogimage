package cn.wuaijing.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


public  class TimerUtil {
    private static final Logger logger = LogManager.getLogger(TimerUtil.class.getName());
    public void printSimpleTrigger(){
       // System.out.println("simpleTrigger正在执行定时"+ new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("simpleTrigger开始执行" + new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
    }
    public void printCronTrigger(){
       // System.out.println("cronTrigger正在执行定时"+ new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("cronTrigger正在执行定时"+ new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

