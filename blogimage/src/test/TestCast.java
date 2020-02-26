import cn.wuaijing.util.WeChatUtils;
import cn.wuaijing.util.constants.WeChatXMLLabel;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;

public class TestCast {
    public static void main(String[] args) {
        HashMap<String, String> objectHashMap = new HashMap<>();
        objectHashMap.put("node", "1");
        objectHashMap.put("node1", "2");
        objectHashMap.put("<node1>", "<3>");
        objectHashMap.put(WeChatXMLLabel.PUBLIC_LABEL_MSGID, "4");
        String str = WeChatUtils.pareToTextXml(objectHashMap);
        //System.out.println(doc.toString());
        System.out.println(str);
    }
}