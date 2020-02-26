import cn.wuaijing.bean.AccessToken;
import cn.wuaijing.bean.AppToken;
import cn.wuaijing.service.AccessTokenService;
import cn.wuaijing.service.impl.AccessTokenServiceImpl;
import cn.wuaijing.util.CastAccessTokenUtil;
import cn.wuaijing.util.HttpUtil;

import cn.wuaijing.util.PareStringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccessTokenService {

    private String host="https://api.weixin.qq.com";
    private String path="/cgi-bin/token";
    private Map<String, String> map = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(AccessTokenServiceImpl.class.getName());

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private AccessToken accessToken;
    @Test
    public void getAccessToken(){
        System.out.println("\t\t");
        System.out.println("打印的值是："+accessToken.getAppId());
      // JSONObject jsonObject = accessTokenService .getAccessToken();
       // System.out.println(jsonObject.toString());
    }
    @Test
    public void getAccessToken1() {
        System.out.println(accessTokenService.getTokenToRedis());
        /*if(!appToken.isEmpty()){

            arrAppToken = stringBuffer.append("[")
                    .append(appToken)
                    .append("]")
                    .toString();
            jsonArray = JSONObject.parseArray(arrAppToken);
            for(int i = 0; i<jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                for (Map.Entry<String, Object> entry : jsonObject.entrySet()
                ) {
                    String key = entry.getKey();
                    String value = entry.getValue().toString();
                    System.out.println("json字符串中的键值对：key是" + key + "   value是" + value);
                    redisTemplate.opsForValue().set(key ,value,2, TimeUnit.HOURS);
                    logger.info("成功");
                }
            }

    }*/
    }
}
