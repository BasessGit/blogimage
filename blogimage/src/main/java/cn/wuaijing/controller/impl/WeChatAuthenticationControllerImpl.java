package cn.wuaijing.controller.impl;

import cn.wuaijing.controller.WeChatAuthenticationController;
import cn.wuaijing.util.SHA1Utils;
import cn.wuaijing.util.WeChatToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WeChatAuthenticationControllerImpl implements WeChatAuthenticationController {

    @RequestMapping(value = "/weChat", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public long getWeChatAuthentication(String signature, String timestamp, String nonce, String echostr) {
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:" +echostr);
        System.out.println(WeChatToken.TOKEN);
        String[]  arr = {timestamp, nonce,  WeChatToken.TOKEN};
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr
             ) {
            stringBuilder.append(s);
        }
        System.out.println("这个是啥："+SHA1Utils.SHA1(stringBuilder.toString()));

        if(SHA1Utils.SHA1(stringBuilder.toString()).equals(signature)){
            System.out.println("返回了这个");
            return Long.parseLong(echostr);

        }
        System.out.println("返回了错误");
       return Long.parseLong("0");
    }

}
