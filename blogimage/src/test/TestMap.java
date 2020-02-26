import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","王伟");
        map.put("2","许静");
        for (Map.Entry<String,String> entry : map.entrySet()
             ) {
            System.out.println(entry.getKey());
        }
    }
}
