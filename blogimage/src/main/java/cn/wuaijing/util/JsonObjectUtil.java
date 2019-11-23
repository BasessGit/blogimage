package cn.wuaijing.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class JsonObjectUtil {
    public static JSONObject castJsonObject(HttpResponse httpResponse) throws IOException {
       HttpEntity entity = httpResponse.getEntity();
       String strEntity = EntityUtils.toString(entity);
        System.out.println("值是"+strEntity);
       EntityUtils.consume(entity);
       return JSONObject.parseObject(strEntity);


    }
}
