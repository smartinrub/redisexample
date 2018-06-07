import redis.clients.jedis.Jedis;

public class JedisExample {

    private static final String MY_KEY = "my_key";
    private static final String MY_VALUE = "my_value";

    private static Jedis redis = null;

    public static void main(String[] args) {

        redis = JedisSingleton.getInstance().getJedisPool().getResource();

        redis.set(MY_KEY, MY_VALUE);

        String value = redis.get(MY_KEY);
        System.out.println("My value is: " + value);
    }
}
