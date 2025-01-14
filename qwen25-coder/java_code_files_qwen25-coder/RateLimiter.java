public class RateLimiter {

    private static final int MAX_REQUESTS_PER_MINUTE = 100;

    public void checkRateLimit(String ipAddress) throws TooManyRequestsException {
        int requestCount = getRequestCountFromDatabase(ipAddress);
        if (requestCount > MAX_REQUESTS_PER_MINUTE) {
            throw new TooManyRequestsException("Too many requests from this IP.");
        }
        incrementRequestCountInDatabase(ipAddress);
    }

    private int getRequestCountFromDatabase(String ipAddress) {
        // For the purpose of this example, return a dummy value
        return 0;
    }

    private void incrementRequestCountInDatabase(String ipAddress) {
        // For the purpose of this example, do nothing
    }

    public static void main(String[] args) {
    }
}

class TooManyRequestsException extends Exception {
    public TooManyRequestsException(String message) {
        super(message);
    }
}