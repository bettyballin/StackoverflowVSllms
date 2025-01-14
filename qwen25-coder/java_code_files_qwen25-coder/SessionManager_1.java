import java.lang.String;
import redis.clients.jedis.Jedis;

public class SessionManager_1 {
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    
    public void setAttribute(String sessionId, String attributeKey, String attributeValue) {
        try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {
            String redisKey = sessionId + ":" + attributeKey;
            jedis.set(redisKey, attributeValue);
        }
    }

    public String getAttribute(String sessionId, String attributeKey) {
        try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {
            String redisKey = sessionId + ":" + attributeKey;
            return jedis.get(redisKey);
        }
    }

    public static void main(String[] args) {
    }
}