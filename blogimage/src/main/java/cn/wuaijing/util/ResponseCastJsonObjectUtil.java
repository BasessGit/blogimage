package cn.wuaijing.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ResponseCastJsonObjectUtil {
    public static JSONObject castJsonObject(HttpResponse httpResponse) throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        String res = EntityUtils.toString(entity,"utf-8");
        EntityUtils.consume(entity);
        return JSONObject.parseObject(res);
    }
}
