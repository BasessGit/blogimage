package cn.wuaijing.util;



import cn.wuaijing.util.constants.WeChat;
import cn.wuaijing.util.constants.WeChatXMLLabel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.AbstractCDATA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeChatUtils implements Serializable {


    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatUtils.class);
    private static final long serialVersionUID = 8502462531477237956L;
    /**
    * @Description SHA1加密工具
    * @Author wangwei
    * @Date   2020/2/22 11:52
    * @Param
    * @Return   String
    * @Exception
    *
    */
    private static String SHA1(String str){
        if(str == null || str.length()==0){
            return null;
        }
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for(int i=0;i<j;i++){
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
    /**
    * @Description 判断消息是否来自微信服务器
    * @Author wangwei
    * @Date   2020/2/23 11:41
    * @Param   HttpServletRequest
    * @Return   boolean
    * @Exception
    *
    */
    public static boolean isSignature(HttpServletRequest httpServletRequest){
        String signature = httpServletRequest.getParameter(WeChat.SIGNATURE);
        String nonce = httpServletRequest.getParameter(WeChat.NONCE);
        String timestamp = httpServletRequest.getParameter(WeChat.TIMESTAMP);
        LOGGER.debug("http输出："+signature);
        String[]  arr = {timestamp, nonce,  WeChat.TOKEN};
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr
        ) {
            stringBuilder.append(s);
        }

        LOGGER.debug("SHA1输出："+SHA1(stringBuilder.toString()));
        String signatureSha = SHA1(stringBuilder.toString());
            if(signatureSha.equals(signature)){
                return true;
        }else {
                return false;
            }
    }
    /**
    * @Description 将xml类型转换成Map<String, Object>类型
    * @Author wangwei
    * @Date   2020/2/25 11:20
    * @Param  httpServletRequest对象
    * @Return      Map<String, Object>
    * @Exception
    *
    */
    public static Map<String, Object> xmlToMap(HttpServletRequest httpServletRequest) throws IOException {
        Map<String, Object> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        InputStream input = null;

        try {
            input = httpServletRequest.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
           doc =  reader.read(input);
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            input.close();
        }
        //获取根节点
        Element element =  doc.getRootElement();
        List<Element> roots = element.elements();
        for (Element e : roots
             ) {
            LOGGER.debug("key: "+e.getName()+"   value :"+e.getText());
            map.put(e.getName(),e.getData());
        }
        return map;
    }

    /**
    * @Description 将Map<String,String >转换成xml格式
    * @Author wangwei
    * @Date   2020/2/25 11:17
    * @Param
    * @Return    xml
    * @Exception
    *
    */
    public static String pareToTextXml(Map<String,String> mapElements){
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("xml");
        XMLWriter xmlWriter = new XMLWriter();
        for (Map.Entry<String, String> entry : mapElements.entrySet()
             ) {
            Element element = rootElement.addElement(entry.getKey());
            if (WeChatXMLLabel.PUBLIC_LABEL_CREATETIME.equals(entry.getKey()) || WeChatXMLLabel.PUBLIC_LABEL_MSGID.equals(entry.getKey())){
                element.addText(entry.getValue());
            }else {
                element.addText("<![CDATA[" + entry.getValue() + "]]>");
            }
        }
        String xmlToString = formatXml(document,"UTF-8",false);
        return xmlToString;
    }

    /**
    * @Description 格式化xml文件
    * @Author wangwei
    * @Date   2020/2/25 11:14
    * @Param     document xml文档对象,  charset 编码,  istrans 是否转义特殊字符
    * @Return      String  xml
    * @Exception   IOException
    *
    */
    public static String formatXml(Document document, String charset, boolean istrans) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(charset);
        format.setIndent(true);
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw, format);
        xw.setEscapeText(istrans);
        try {
            xw.write(document);
            xw.flush();

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.warn("刷新格式异常");
        } finally {
            try {
                if (xw != null) {
                    xw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.warn("关闭异常");
            }
        }
        return sw.toString();
    }
}
