import cn.wuaijing.service.WeatherService;
import cn.wuaijing.service.WeatherServiceImpl;
import cn.wuaijing.util.PareStringUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGuangDong {


    @Autowired
    private WeatherService weatherService;

        @Test
        public  void testWeatherService(){

        String res = weatherService.getWeather("GET");

        }
        @Test
        public void testInWeatherJOSN(){
        JSONObject jsonObject =  weatherService.getWeatherToJSON("GET");
        System.out.println(jsonObject.toString());

    }
}
