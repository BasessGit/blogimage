import cn.wuaijing.controller.WeatherController;
import cn.wuaijing.service.WeatherService;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGuangDong {


    @Autowired
    private WeatherService weatherService;

    @Autowired
   private WeatherController weatherController;

        @Test
        public  void testWeatherService(){

        String res = weatherService.getWeather();

        }
        @Test
        public void testInWeatherJOSN(){
            Map<String,String> q = new HashMap<>();
        JSONObject jsonObject =  weatherService.getWeatherToJSON(q);

        System.out.println(jsonObject.toString());

    }

    @Test
    public void testWeatherController(){

       System.out.println("controller"+ weatherController.getWeatherController().toString());

    }

}
