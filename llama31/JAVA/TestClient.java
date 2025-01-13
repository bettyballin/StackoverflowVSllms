import java.lang.String;

public class TestClient {
    public static void main(String[] args) {
        // Create a stub with the connection pool configuration
        YourServiceStub stub = new YourServiceStub();

        // Send multiple requests in a loop
        for (int i = 0; i < 100; i++) {
            try {
                stub.yourMethod();
                Thread.sleep(100); // delay between requests
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// The YourServiceStub class was missing, so I added a basic implementation
class YourServiceStub {
    public void yourMethod() {
        System.out.println("yourMethod called");
    }
}