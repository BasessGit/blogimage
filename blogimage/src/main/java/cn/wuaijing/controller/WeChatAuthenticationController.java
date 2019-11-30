package cn.wuaijing.controller;

public interface WeChatAuthenticationController {
    public long getWeChatAuthentication(String signature, String timeTamp, String nonce, String echostr);
}
