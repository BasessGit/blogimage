package cn.wuaijing.bean.inmessage;

public class WeChatInMessageText extends WeChatInMessage {
    private String content;


    public WeChatInMessageText() {
        super();
    }

    public WeChatInMessageText(String toUserName, String fromUserName, Integer createTime, String msgType, Long msgId, String content) {
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
        return "WeChatInMessageText{" +
                "content='" + content + '\'' +
                '}';
    }
}
