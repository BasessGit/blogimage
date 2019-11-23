import cn.wuaijing.util.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TestBuildUrl {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("a","123");
        stringMap.put("b","2222");
        stringMap.put("","121");
      //String s = HttpUtil.buildUrl("https://blog.csdn.net","/ll641058431/article/details/79566277",stringMap);
        System.out.println("这个网址是：" );
    }
}
