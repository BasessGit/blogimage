package cn.wuaijing.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PareStringUtil {
    public static String pareString(HttpResponse httpResponse) throws IOException {
        HttpEntity httpEntity = httpResponse.getEntity();
       String res =  EntityUtils.toString(httpEntity,"utf-8");
        EntityUtils.consume(httpEntity);
        return res;
    }
}
