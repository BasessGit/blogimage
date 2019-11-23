package cn.wuaijing.controller;

import cn.wuaijing.bean.User;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/xiaoming")
    @ResponseBody
    public JSONPObject  getJson(){
        List<Object> list = new ArrayList<>();
        User user = new User(null,null,new Date(),null);
        JSONPObject jsonpObject = new JSONPObject("测试");
        jsonpObject.addParameter(user);
        String json = jsonpObject.toJSONString();
        System.out.println(json);
      list = jsonpObject.getParameters();
      for(Object o :list){
          User user1 =(User) o;
          System.out.println(user1.getDate());
      }

        return jsonpObject;
    }

}
