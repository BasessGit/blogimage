package cn.wuaijing.service;

import com.alibaba.fastjson.JSONObject;

public interface WeatherService {
    public String getWeather(String method);
    public JSONObject getWeatherToJSON(String method);

}
