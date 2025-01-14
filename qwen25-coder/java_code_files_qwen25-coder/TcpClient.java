public class TcpClient {
    private boolean isConnected;
    private int maxReconnectionAttempts = 5; // Set a limit on the number of attempts
    private long reconnectionDelay = 10000; // Delay between attempts (e.g., 10 seconds)

    public void connect() {
        int attemptCount = 0;

        while (!isConnected && attemptCount < maxReconnectionAttempts) {
            try {
                // Code to establish the TCP connection
                System.out.println("Attempting to connect...");
                Thread.sleep(200); // Simulate connection attempt
                isConnected = true; // Connection successful
                System.out.println("Connection established.");
            } catch (Exception e) {
                attemptCount++;
                System.out.println("Failed to connect. Attempt " + attemptCount);
                try {
                    Thread.sleep(reconnectionDelay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }

            if (!isConnected) {
                System.out.println("Max attempts reached. No more retries.");
            }
        }
    }

    public static void main(String[] args) {
        TcpClient client = new TcpClient();
        client.connect();
    }
}