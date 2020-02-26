package cn.wuaijing.bean.outmessage;

import cn.wuaijing.bean.inmessage.WeChatInMessage;

public class WeChatOutMessageText extends WeChatInMessage {
    private String content;


    public WeChatOutMessageText() {
        super();
    }

    public WeChatOutMessageText(String toUserName, String fromUserName, Integer createTime, String msgType, Long msgId, String content) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        super.toString();
        return "WeChatOutMessageText{" +
                "content='" + content + '\'' +
                '}';
    }
}