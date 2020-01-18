import cn.wuaijing.util.TimerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTrim {

    private TimerUtil timerUtil = new TimerUtil();
    @Test
    public void doTestTrim(){
        timerUtil.printCronTrigger();
        timerUtil.printSimpleTrigger();
    }
}
