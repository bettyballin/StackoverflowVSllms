import java.lang.String;
import java.util.concurrent.TimeUnit;

public class ExternalServiceCaller {
    private static final int MAX_RETRIES = 5;
    private static final long INITIAL_BACKOFF_MS = 1000; // 1 second

    public void callExternalService() throws Exception {
        int attempt = 1;
        while (attempt <= MAX_RETRIES) {
            try {
                performExternalCall();
                return; // successful, exit the loop
            } catch (Exception e) {
                if (attempt == MAX_RETRIES)
                    throw new RuntimeException("Max retries reached. Could not complete external call.", e);
                long backoff = INITIAL_BACKOFF_MS * (long)Math.pow(2, attempt - 1);
                TimeUnit.MILLISECONDS.sleep(backoff);
            }
            attempt++;
        }
    }

    private void performExternalCall() throws Exception {
        // Logic to call the external service
        // Simulate an exception for demonstration purposes
        throw new Exception("Simulated service failure");
    }

	public static void main(String[] args) {
	}
}