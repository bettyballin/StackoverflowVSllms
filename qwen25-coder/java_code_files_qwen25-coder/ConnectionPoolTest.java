import java.util.Set;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolTest {

    private static final int MAX_CONNECTIONS_PER_HOST = 20;
    private static final int IDLE_CONNECTION_TIMEOUT = 30000; // milliseconds
    private static final int THREAD_POOL_SIZE = 10;
    private static final int NUMBER_OF_REQUESTS = 50;

    public static void main(String[] args) throws InterruptedException {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = connectionManager.getParams();
        params.setDefaultMaxConnectionsPerHost(MAX_CONNECTIONS_PER_HOST);
        
        // Set idle timeout
        connectionManager.closeIdleConnections(IDLE_CONNECTION_TIMEOUT);

        HttpClient httpClient = new HttpClient(connectionManager);
        YourStub stub = new YourStub();

        ServiceClient serviceClient = stub._getServiceClient();
        serviceClient.getOptions().setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
        serviceClient.getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_REQUESTS; i++) {
            executorService.submit(() -> {
                try {
                    // Make a SOAP call using the stub
                    stub.yourSOAPMethod();
                    System.out.println("Request completed successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        // Simulate another test where you wait and check if connections are closed
        Thread.sleep(IDLE_CONNECTION_TIMEOUT + 5000); // Wait longer than IDLE_CONNECTION_TIMEOUT

        // Optionally, add logging to HttpClient or use a network monitoring tool like Wireshark
        // to observe that connections are being reused and closed after idle timeout.
    }
}

class YourStub {
    public ServiceClient _getServiceClient() {
        return new ServiceClient();
    }

    public void yourSOAPMethod() {
        // Placeholder method to simulate a SOAP call
    }
}