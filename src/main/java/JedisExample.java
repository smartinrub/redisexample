import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.logging.Logger;

public class JedisExample {

    private static final Logger LOGGER = Logger.getLogger(JedisExample.class.getName());

    private static final String MY_KEY = "my_key";
    private static final String MY_VALUE = "my_value";

    public static void main(String[] args) {

        Jedis redis = null;

        try {
            redis = JedisSingleton.getInstance().getJedisPool().getResource();
            redis.set(MY_KEY, MY_VALUE);
            String value = redis.get(MY_KEY);
            LOGGER.info("My value is: " + value);
        } catch (JedisConnectionException e) {
            LOGGER.severe("Connection error!");
            if (redis != null) {
                JedisSingleton.getInstance().getJedisPool().returnBrokenResource(redis);
                redis = null;
            }
            throw e;
        } finally {
            if (redis != null) {
                JedisSingleton.getInstance().getJedisPool().returnResource(redis);
            }
        }
    }
}
