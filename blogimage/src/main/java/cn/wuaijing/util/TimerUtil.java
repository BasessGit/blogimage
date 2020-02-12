package cn.wuaijing.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import javax.xml.ws.soap.Addressing;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public  class TimerUtil {
    private static final Logger logger = LogManager.getLogger(TimerUtil.class.getName());
    @Autowired
    private AttianAccessTokenUtil attianAccessTokenUtil;
    public void printSimpleTrigger(){

        System.out.println("simpleTrigger正在执行定时"+ new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("simpleTrigger开始执行" + new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        attianAccessTokenUtil.getAccessToken();
    }
    public void printCronTrigger(){
       // System.out.println("cronTrigger正在执行定时"+ new Sim pleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        //logger.info("cronTrigger正在执行定时"+ new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

