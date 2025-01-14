import com.google.common.util.concurrent.RateLimiter;

public class RateLimitingFetcher {
    RateLimiter rateLimiter = RateLimiter.create(1.0); // one request per second

    public void fetchUrl(String url) {
        if (rateLimiter.tryAcquire()) {
            // Proceed with fetching the URL
        } else {
            throw new RuntimeException("Rate limit exceeded");
        }
    }

    public static void main(String[] args) {
    }
}