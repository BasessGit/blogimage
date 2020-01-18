import redis.clients.jedis.Jedis;

public class TestJedis {
    public static void main(String[] args) {
        Jedis jedis =new Jedis("127.0.0.1",6379,3000);
        jedis.auth("test");
        jedis.set("s","123");
        String string = jedis.get("s");
        System.out.println(string);
    }
}
