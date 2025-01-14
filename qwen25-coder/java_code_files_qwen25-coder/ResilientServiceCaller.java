import java.time.Duration;

public class ResilientServiceCaller {
    private CircuitBreaker circuitBreaker;
    private ExponentialBackoffRetryPolicy retryPolicy;

    public ResilientServiceCaller() {
        // Initialize with appropriate thresholds and policies
        this.circuitBreaker = new CircuitBreaker(10, Duration.ofSeconds(30));
        this.retryPolicy = new ExponentialBackoffRetryPolicy(Duration.ofMillis(50), 3);
    }

    public void callExternalSystem(Service operation) {
        if (circuitBreaker.isCallPermitted()) {
            try {
                retryPolicy.execute(operation::execute);
                circuitBreaker.reportSuccess();
            } catch (Exception e) {
                circuitBreaker.reportFailure(e);
                // Log the failure, possibly persist the request for later
            }
        } else {
            System.out.println("Service is unreliable; Operation not executed.");
        }
    }

    interface Service {
        void execute() throws Exception;
    }

    public static class CircuitBreaker {
        private int failureThreshold;
        private Duration resetTimeout;
        private int failureCount = 0;
        private long lastFailureTime = 0;
        private State state = State.CLOSED;

        public CircuitBreaker(int failureThreshold, Duration resetTimeout) {
            this.failureThreshold = failureThreshold;
            this.resetTimeout = resetTimeout;
        }

        public boolean isCallPermitted() {
            if (state == State.OPEN) {
                if ((System.currentTimeMillis() - lastFailureTime) > resetTimeout.toMillis()) {
                    state = State.HALF_OPEN;
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        public void reportSuccess() {
            if (state == State.HALF_OPEN || state == State.OPEN) {
                reset();
            }
        }

        public void reportFailure(Exception e) {
            failureCount++;
            lastFailureTime = System.currentTimeMillis();
            if (failureCount >= failureThreshold) {
                state = State.OPEN;
            }
        }

        private void reset() {
            failureCount = 0;
            state = State.CLOSED;
        }

        private enum State {
            CLOSED,
            OPEN,
            HALF_OPEN
        }
    }

    public static class ExponentialBackoffRetryPolicy {
        private Duration initialDelay;
        private int maxRetries;

        public ExponentialBackoffRetryPolicy(Duration initialDelay, int maxRetries) {
            this.initialDelay = initialDelay;
            this.maxRetries = maxRetries;
        }

        public void execute(OperationWithException operation) throws Exception {
            int attempt = 0;
            long delay = initialDelay.toMillis();

            while (true) {
                try {
                    operation.execute();
                    return;
                } catch (Exception e) {
                    attempt++;
                    if (attempt > maxRetries) {
                        throw e;
                    }
                    Thread.sleep(delay);
                    delay *= 2;  // Exponential backoff
                }
            }
        }
    }

    @FunctionalInterface
    public interface OperationWithException {
        void execute() throws Exception;
    }
}