package cn.wuaijing.service.impl;

import cn.wuaijing.bean.AccessToken;
import cn.wuaijing.service.AccessTokenService;
import cn.wuaijing.util.CastAccessTokenUtil;
import cn.wuaijing.util.HttpUtil;

import cn.wuaijing.util.PareStringUtil;
import org.apache.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 *  @author: wangwei
 *  @Date: 2020/2/20 15:30
 *  @Description: 发送请求获取AccessToken
 */
@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenServiceImpl.class);
    private static final String tokenKey = "access_token";
    @Autowired
    private AccessToken accessToken;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
    * @Description 向微信服务器发送请求，得到Json对象，并存储到Map集合中
    * @Author wangwei
    * @Date   2020/2/20 15:29
    * @Param
    * @Return       Map<String, String>
    * @Exception   IOException
    *
    */
    @Override
    public Map<String, String> getAccessTokenMap() {
        Map<String, String> map = new HashMap<>();
        if (accessToken.getAppId() != null ) {
            map.put("appid", accessToken.getAppId());
        }
        if (accessToken.getGrant_type() != null) {
            map.put("grant_type", accessToken.getGrant_type());
        }
        if (accessToken.getSecret() != null) {
            map.put("secret", accessToken.getSecret());
        }
        if (accessToken.getPath() != null  && accessToken.getHost() != null) {
            HttpResponse httpResponse = null;
            try {
                httpResponse = HttpUtil.SendGet(accessToken.getHost(), accessToken.getPath(), map);
                //logger.info("返回的状态码是" + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse == null) {
                    LOGGER.error("获取httpResponse异常");
                }
                switch (httpResponse.getStatusLine().getStatusCode()) {
                    case 200:
                        String httpRes = PareStringUtil.pareString(httpResponse);
                        map = CastAccessTokenUtil.castAccessTokenToJsonArray(httpRes);
                        LOGGER.info("\t\t"+"map集合有"+map.size()+"个值");
                        return map;

                        default:
                            LOGGER.error("获取状态码异常");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.info("HttpResponse异常");

            }


        }
        return null;
    }

    /**
    * @Description 获取AccessTonken
    * @Author wangwei
    * @Date   2020/2/20 15:28
    * @Param
    * @Return
    * @Exception
    *
    */
    @Override
    public String getTokenToRedis() {
        LOGGER.info("getTokenToRedis方法在执行");
        if(redisTemplate.opsForValue().get(tokenKey) == null){
            LOGGER.info("redis中没有值");
              return  executionTimerSaveTokenInRedis();
        }
        LOGGER.info("redis中有值");
        return  redisTemplate.opsForValue().get(tokenKey);
    }

    /**
    * @Description 定时获取Access_Token并存储redis
    * @Author wangwei
    * @Date   2020/2/20 15:26
    * @Param
    * @Return  String entry.getValue()
    * @Exception
    *
    */
    @Override
     public String executionTimerSaveTokenInRedis() {
        if (getAccessTokenMap() == null) {
            LOGGER.warn("未执行获取token");
        }
        for (Map.Entry<String, String> entry : getAccessTokenMap().entrySet()
        ) {
            if (tokenKey.equals(entry.getKey())) {
                LOGGER.info("\t\t"+"map集合"+ entry.getKey());
                LOGGER.info("获取到的tonken:"+entry.getValue());
                redisTemplate.opsForValue().set(entry.getKey(), entry.getValue(), 2, TimeUnit.HOURS);
                LOGGER.info("redis返回回值:"+redisTemplate.opsForValue().get(entry.getKey()));
                return entry.getValue();
            }
        }
        return null;
    }

}