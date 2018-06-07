import redis.clients.jedis.Jedis;

public class JedisExample {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("password");
        System.out.println("Connected to Redis");
    }
}
