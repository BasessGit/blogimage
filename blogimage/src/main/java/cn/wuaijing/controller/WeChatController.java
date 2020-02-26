package cn.wuaijing.controller;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WeChatController {
   // public Long getWeChatAuthentication(String signature, String timeTamp, String nonce, String echostr);
    public Long getWeChatAuthentication(String signature,HttpServletRequest res,HttpServletResponse req);
    public void getWeChatParam(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
