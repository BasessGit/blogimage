package cn.wuaijing.controller.impl;

import cn.wuaijing.bean.WeatherURL;
import cn.wuaijing.controller.WeatherController;
import cn.wuaijing.service.WeatherService;
import cn.wuaijing.service.impl.WeatherServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import java.util.HashMap;
import java.util.Map;

@Controller
public class WeatherControllerImpl implements WeatherController {

    @Autowired
    private WeatherService weatherService;
  

    @Override
    public JSONObject getWeatherController() {
        Map<String,String> query = new HashMap<>();
        query.put("area","江海区");
        query.put("city","江门");
        query.put("needday","1");
        query.put("prov","广东");
       JSONObject jsonObject = weatherService.getWeatherToJSON(query);
       return  jsonObject;
    }
}
