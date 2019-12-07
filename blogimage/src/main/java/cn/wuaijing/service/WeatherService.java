package cn.wuaijing.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface WeatherService {
     String getWeather();
     JSONObject getWeatherToJSON(Map<String, String> newQuery);

}
