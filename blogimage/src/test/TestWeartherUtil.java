import cn.wuaijing.util.WeatherUtil;

import java.util.HashMap;
import java.util.Map;

public class TestWeartherUtil {
    public static void main(String[] args) {
        Map<String,String> urlMap = new HashMap<String, String>();
        urlMap.put("area","西湖");
        urlMap.put("city","杭州");
        urlMap.put("needday","1");
        urlMap.put("prov","浙江");
       String s =  WeatherUtil.sendGet("http(s)://iweather.market.alicloudapi.com/address",urlMap);
        System.out.println(s);
    }
}
