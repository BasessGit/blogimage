package cn.wuaijing.util;

import cn.wuaijing.bean.AccessToken;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CastAccessTokenUtil {
    private final Logger logger = LogManager.getLogger(CastAccessTokenUtil.class.getName());
   public static Map<String,String> castAccessTokenToJsonArray(String accessToken) {
       Map<String,String> access = new HashMap<>();
       if (!accessToken.isEmpty()) {
           StringBuilder stringBuilder = new StringBuilder();
           accessToken = stringBuilder.append("[")
                   .append(accessToken)
                   .append("]")
                   .toString();
           JSONArray  jsonArray = JSONObject.parseArray(accessToken);
           for (int i = 0; i <jsonArray.size() ; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
               for (Map.Entry<String, Object> entry : jsonObject.entrySet()){
                   access.put(entry.getKey(), entry.getValue().toString());
               }


               }
           return access;
           }
           return null;
       }

}
