package cn.wuaijing.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface WeatherService {
    public String getWeather();
    public JSONObject getWeatherToJSON(Map<String, String> newQuery);

}
