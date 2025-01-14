import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfiguration {
    private static JedisPool pool;

    public static void initialize(String host, int port) {
        pool = new JedisPool(new JedisPoolConfig(), host, port);
    }

    public static JedisPool getJedisPool() {
        return pool;
    }
}