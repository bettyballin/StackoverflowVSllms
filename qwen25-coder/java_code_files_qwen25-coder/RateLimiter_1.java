// Example of a simple rate limiting mechanism in Java
import java.util.HashMap;
import java.util.Map;

public class RateLimiter_1 {
    private final Map<String, Integer> requestCount = new HashMap<>();
    private static final int REQUEST_LIMIT = 100; // Maximum requests allowed per time period

    public boolean isAllowed(String userId) {
        int currentCount = requestCount.getOrDefault(userId, 0);
        if (currentCount < REQUEST_LIMIT) {
            requestCount.put(userId, currentCount + 1);
            return true;
        }
        return false;
    }

    // Reset requests count periodically
    public void resetRequests() {
        requestCount.clear();
    }

    public static void main(String[] args) {
    }
}