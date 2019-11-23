import cn.wuaijing.bean.WeatherURL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class TestAppclication {
    public static void main(String[] args) {

        ApplicationContext appletContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        WeatherURL url =   appletContext.getBean(WeatherURL.class);
        System.out.println(url.getHost());
    }
}
