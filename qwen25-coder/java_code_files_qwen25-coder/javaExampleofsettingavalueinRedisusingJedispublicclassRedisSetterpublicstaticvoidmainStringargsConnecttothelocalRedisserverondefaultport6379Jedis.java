// Example of setting a value in Redis using Jedis

import java.lang.String;
import redis.clients.jedis.Jedis;

public class RedisSetter {
    public static void main(String[] args) {
        // Connect to the local Redis server on default port 6379
        Jedis jedis = new Jedis("localhost");
        jedis.set("session_id:user_123", "logged_in");
    }
}