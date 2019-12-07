package cn.wuaijing.controller;

public interface WeChatAuthenticationController {
    public Long getWeChatAuthentication(String signature, String timeTamp, String nonce, String echostr);
}
