package cn.wuaijing.util;

import cn.wuaijing.bean.AccessToken;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class AttianAccessTokenUtil {
    private final Logger logger = LogManager.getLogger(AttianAccessTokenUtil.class.getName());
    @Autowired
    private AccessToken accessToken;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public  void getAccessToken() {
        HttpResponse httpResponse = null;
        Map<String, String> map = new HashMap<>();
        String httpRes = "";
        //logger.info("看一下里面是否有值"+accessToken.getAppid());
        if (!accessToken.getAppid().isEmpty()) {
            map.put("appid", accessToken.getAppid());
        }
        if (!accessToken.getGrant_type().isEmpty()) {
            map.put("grant_type", accessToken.getGrant_type());
        }
        if (!accessToken.getSecret().isEmpty()) {
            map.put("secret", accessToken.getSecret());
        }
        if (!accessToken.getPath().isEmpty() && !accessToken.getHost().isEmpty()) {
            try {
                httpResponse = HttpUtil.SendGet(accessToken.getHost(), accessToken.getPath(), map);
                httpRes = PareStringUtil.pareString(httpResponse);
            } catch (IOException e) {
                logger.warn("获取httpResponse异常" + e.getMessage());
                e.printStackTrace();
            }
        }

        if (!httpRes.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            httpRes = stringBuilder.append("[")
                    .append(httpRes)
                    .append("]")
                    .toString();
            JSONArray jsonArray = JSONObject.parseArray(httpRes);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                for (Map.Entry<String, Object> mapEntry : jsonObject.entrySet()
                ) {
                    String key = mapEntry.getKey();
                    String value = mapEntry.getValue().toString();
                    redisTemplate.opsForValue().set(key, value, 2, TimeUnit.HOURS);
                    System.out.println("key:" + key + ",value:" + value);
                }
            }

        }
    }
}