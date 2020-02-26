package cn.wuaijing.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface AccessTokenService {
    Map<String, String> getAccessTokenMap();
    String getTokenToRedis();
    String executionTimerSaveTokenInRedis();


}
