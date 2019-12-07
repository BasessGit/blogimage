package cn.wuaijing.service.impl;

import cn.wuaijing.service.AccessTokenService;
import cn.wuaijing.util.HttpUtil;
import cn.wuaijing.util.ResponseCastJsonObject;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    private String host="https://api.weixin.qq.com";
    private String path="/cgi-bin/token";
    private Map<String, String> map = new HashMap<>();
    private  JSONObject appToken;
    private static final Logger logger = LogManager.getLogger(AccessTokenServiceImpl.class.getName());

    @Override
    public JSONObject getAccessToken() {

        map.put("grant_type","client_credential");
        map.put("appid", "wx6f0c09bc8228d5b4");
        map.put("secret", "4bde38a25b6a6de4ec697d0a6cae66df");
        try {
              HttpResponse httpResponse =  HttpUtil.SendGet(host,path,map);
           appToken  = ResponseCastJsonObject.castJsonObject(httpResponse);

        } catch (IOException e) {
           e.printStackTrace();
            logger.info("HttpResponse异常");
        }
        return appToken;
    }
}
