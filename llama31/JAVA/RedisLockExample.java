import redis.clients.jedis.Jedis;

public class RedisLockExample {
    public static void main(String[] args) {
        // Create a Jedis client
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            String messageGroupId = "example-group-id"; // Define the message group ID
            // Acquire a lock on a message group
            String lockKey = "myapp:locks:" + messageGroupId;
            if (jedis.set(lockKey, "locked", "NX", "EX", 30) != null) {
                // Process the message
                System.out.println("Acquired lock, processing message...");
            } else {
                // Wait for the lock to be released
                jedis.expire(lockKey, 30);
                System.out.println("Failed to acquire lock, waiting for release...");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}