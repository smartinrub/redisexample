import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

public class JedisSingleton {

    private static volatile JedisSingleton instance = null;

    private static JedisPool pool;

    private JedisSingleton() {
        pool = new JedisPool(
                new JedisPoolConfig(),
                "localhost",
                6379,
                Protocol.DEFAULT_TIMEOUT,
                "password"
        );
    }

    public static JedisSingleton getInstance() {
        if (instance == null) {
            synchronized (JedisSingleton.class) {
                if (instance == null) {
                    instance = new JedisSingleton();
                }
            }
        }
        return instance;
    }

    public JedisPool getJedisPool() {
        return pool;
    }
}
