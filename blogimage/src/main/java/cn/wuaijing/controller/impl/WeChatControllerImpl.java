package cn.wuaijing.controller.impl;

import cn.wuaijing.bean.inmessage.WeChatInMessageText;
import cn.wuaijing.controller.WeChatController;
import cn.wuaijing.service.WeChatMessageService;
import cn.wuaijing.util.constants.WeChat;
import cn.wuaijing.util.WeChatUtils;
import cn.wuaijing.util.constants.WeChatXMLLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WeChatControllerImpl implements WeChatController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatControllerImpl.class);

    private WeChatMessageService weChatMessageService;
    @RequestMapping(value = "/weChat", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public Long getWeChatAuthentication(String echostr,HttpServletRequest res,HttpServletResponse req) {
        LOGGER.debug("执行了getWeChatAuthentication()");
        LOGGER.debug("Signature:"+Long.parseLong(echostr));
       if (WeChatUtils.isSignature(res)){
           LOGGER.debug("WeChatUtils返回结果：true");
           return  Long.parseLong(echostr);
       }else {
           return null;
       }

    }

    @RequestMapping(value = "/weChat", method = RequestMethod.POST,produces = "application/xml;charset=utf-8")
    @ResponseBody
    @Override
    public void getWeChatParam(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> xmlMap = new HashMap<>();
       ;
       String xml = "";
        try {
            httpServletRequest.setCharacterEncoding("utf-8");
            httpServletResponse.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(WeChatUtils.isSignature(httpServletRequest)){
            try {
              xmlMap =   WeChatUtils.xmlToMap(httpServletRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取接收到的数据类型是text,或者music等
            String msgType = (String) xmlMap.get(WeChatXMLLabel.PUBLIC_LABEL_MSGTYPE);
            LOGGER.debug("msgType: " +msgType);
            switch (msgType){
                //数据是text分支
                case WeChat.MESSAGE_TYPE_TEXT :
                    LOGGER.debug("执行：MESSAGE_TYPE_TEXT 开始");
                    xml= weChatMessageService.getWeChatMessageText(xmlMap);
                    LOGGER.debug("执行：MESSAGE_TYPE_TEXT 完成");
                    try {
                        httpServletResponse.getWriter().write(xml);
                    } catch (IOException e) {
                        e.printStackTrace();
                        LOGGER.warn("响应消息异常");
                        try {
                            httpServletResponse.getWriter().write("");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                case WeChat.MESSAGE_TYPE_MUSIC :
                    //音乐
                default:
                    System.out.println("没有");
            }

        }else {
            try {
                httpServletResponse.sendError(40301,"非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
