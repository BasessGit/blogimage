package cn.wuaijing.controller.impl;

import cn.wuaijing.controller.WeChatAuthenticationController;
import cn.wuaijing.util.SHA1Utils;
import cn.wuaijing.util.WeChatToken;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WeChatAuthenticationControllerImpl implements WeChatAuthenticationController {
    private static final Logger logger = LogManager.getLogger(WeChatAuthenticationControllerImpl.class.getName());
    @RequestMapping(value = "/weChat", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public Long getWeChatAuthentication(String signature, String timestamp, String nonce, String echostr) {

        String[]  arr = {timestamp, nonce,  WeChatToken.TOKEN};
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr
             ) {
            stringBuilder.append(s);
        }


        if(SHA1Utils.SHA1(stringBuilder.toString()).equals(signature)){
            logger.info("这儿应该是对的");
            return Long.parseLong(echostr);

        }

       return null;
    }

}
