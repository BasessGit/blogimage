package cn.wuaijing.service.impl;

import cn.wuaijing.bean.outmessage.WeChatOutMessageText;
import cn.wuaijing.service.WeChatMessageService;
import cn.wuaijing.util.constants.WeChatXMLLabel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeChatMessageServiceImpl implements WeChatMessageService {

    @Override
    public String getWeChatMessageText(Map<String, Object> map) {

        return null;
    }
   /* weChatMessageText.setContent((String) xmlMap.get(WeChatXMLLabel.TEXT_LABEL_CONTENT));
    Integer createTime =Integer.valueOf((String) xmlMap.get(WeChatXMLLabel.PUBLIC_LABEL_CREATETIME));
                    weChatMessageText.setCreateTime(createTime);
                    weChatMessageText.setToUserName((String) xmlMap.get(WeChatXMLLabel.PUBLIC_LABEL_TOUSERNAME));
                    weChatMessageText.setFromUserName((String)xmlMap.get(WeChatXMLLabel.PUBLIC_LABEL_FROMUSERNAME));
                    weChatMessageText.setMsgType((String)xmlMap.get(WeChatXMLLabel.PUBLIC_LABEL_MSGTYPE));
    Long msgId = Long.parseLong((String)xmlMap.get(WeChatXMLLabel.PUBLIC_LABEL_MSGID));
                    weChatMessageText.setMsgId(msgId);*/
}
