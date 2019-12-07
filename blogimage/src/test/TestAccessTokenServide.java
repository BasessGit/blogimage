import cn.wuaijing.service.AccessTokenService;
import cn.wuaijing.service.impl.AccessTokenServiceImpl;
import cn.wuaijing.util.HttpUtil;

import cn.wuaijing.util.PareStringUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccessTokenServide {

    private String host="https://api.weixin.qq.com";
    private String path="/cgi-bin/token";
    private Map<String, String> map = new HashMap<>();
    private  JSONObject appToken;
    private static final Logger logger = LogManager.getLogger(AccessTokenServiceImpl.class.getName());

    @Autowired
    private AccessTokenService accessTokenService;

    @Test
    public void getAccessToken(){
       JSONObject jsonObject = accessTokenService .getAccessToken();
        System.out.println(jsonObject.toString());
    }


    @Test
    public void  geAccessToken() {

        map.put("grant_type","client_credential");
        map.put("appid", "wx6f0c09bc8228d5b4");
        map.put("secret", "4bde38a25b6a6de4ec697d0a6cae66df");
        try {
            HttpResponse httpResponse =  HttpUtil.SendGet(host,path,map);
            String appToken  = PareStringUtil.pareString(httpResponse);
            System.out.println("String:"+appToken);
        } catch (IOException e) {
            logger.info("HttpResponse异常");
        }

    }

}
