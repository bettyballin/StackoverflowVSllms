import java.lang.String;
public class RateLimiter {
    private final long bytesPerSecond; // threshold
    private final int bufferSize; // token bucket size
    private long tokens; // current tokens in bucket
    private long lastRefill; // last refill timestamp

    public RateLimiter(long bytesPerSecond, int bufferSize) {
        this.bytesPerSecond = bytesPerSecond;
        this.bufferSize = bufferSize;
        this.tokens = bufferSize;
        this.lastRefill = System.currentTimeMillis();
    }

    public synchronized int read(byte[] buffer) {
        long now = System.currentTimeMillis();
        refillTokens(now);
        if (tokens < buffer.length) {
            // not enough tokens, block until refilled
            try {
                Thread.sleep((buffer.length - tokens) * 1000 / bytesPerSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            refillTokens(System.currentTimeMillis());
        }
        tokens -= buffer.length;
        return buffer.length;
    }

    private void refillTokens(long now) {
        if (now - lastRefill >= 1000) { // 1 second passed
            tokens = Math.min(bufferSize, tokens + bytesPerSecond);
            lastRefill = now;
        }
    }

	public static void main(String[] args) {
	}
}