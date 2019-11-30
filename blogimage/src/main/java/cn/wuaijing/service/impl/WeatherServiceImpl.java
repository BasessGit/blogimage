package cn.wuaijing.service.impl;

import cn.wuaijing.bean.WeatherURL;
import cn.wuaijing.service.WeatherService;
import cn.wuaijing.util.HttpUtil;
import cn.wuaijing.util.JsonObjectUtil;
import cn.wuaijing.util.PareStringUtil;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherURL weatherURL;

    @Override
    public String getWeather() {
        if ("GET".equals(weatherURL.getMethod())) {
            String host = weatherURL.getHost();
            String path = weatherURL.getPath();
            Map<String, String> query = weatherURL.getQuery();
            Map<String, String> header = weatherURL.getHeader();
            String res = "";
            try {
                HttpResponse httpResponse = HttpUtil.SendGet(host, path, header, query);
                System.out.println("httpresponse的值是：" + httpResponse);
                int code = httpResponse.getStatusLine().getStatusCode();
                if (200 == code) {
                    res = PareStringUtil.pareString(httpResponse);
                    System.out.println("返回值是：" + res);
                } else {
                    System.out.println("未获取到内容");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }
        return null;
    }

    @Override
    public JSONObject getWeatherToJSON(Map<String, String> newQuery) {
        if ("GET".equals(weatherURL.getMethod())) {
            String host = weatherURL.getHost();
            String path = weatherURL.getPath();
            Map<String, String> query = (newQuery.isEmpty()) ? weatherURL.getQuery() : newQuery;
            Map<String, String> header = weatherURL.getHeader();
            JSONObject jsonObject = null;
            try {
                HttpResponse httpResponse = HttpUtil.SendGet(host, path, header, query);
                System.out.println("httpresponse的值是：" + httpResponse);
                int code = httpResponse.getStatusLine().getStatusCode();
                if (200 == code) {
                    jsonObject = JsonObjectUtil.castJsonObject(httpResponse);
                    System.out.println("返回值是：" + jsonObject);
                } else {
                    System.out.println("未获取到内容");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
        return null;
    }

}
