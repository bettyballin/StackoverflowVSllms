import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RequestProcessor_1 {

    private Set<String> processedRequests = new HashSet<>();

    public void processRequest(String requestId, String request) {
        if (!processedRequests.contains(requestId)) {
            // Process the request
            System.out.println("Processing request: " + request);
            // Simulate processing time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            processedRequests.add(requestId);
        } else {
            System.out.println("Duplicate request detected and ignored.");
        }
    }

    public static void main(String[] args) {
        RequestProcessor_1 processor = new RequestProcessor_1();
        String requestId1 = UUID.randomUUID().toString();
        processor.processRequest(requestId1, "Update Balance");
        // Simulate client resending
        processor.processRequest(requestId1, "Update Balance");
    }
}