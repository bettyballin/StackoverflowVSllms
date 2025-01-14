import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class CachingClient {
    private static ConcurrentHashMap<String, String> responseCache = new ConcurrentHashMap<>();

    public String getCachedResponse(String searchCriteria) throws Exception {
        // Try to get cached response
        if (responseCache.containsKey(searchCriteria)) {
            System.out.println("Returning cached response for criteria: " + searchCriteria);
            return responseCache.get(searchCriteria);
        }

        // If not cached, make the web service call
        String response = invokeWebService(searchCriteria);

        // Store the response in cache
        responseCache.putIfAbsent(searchCriteria, response);

        return response;
    }

    private String invokeWebService(String searchCriteria) throws Exception {
        Service service = new Service();
        Call call = (Call) service.createCall();

        // Configure your web service endpoint and method here
        call.setTargetEndpointAddress(new URL("http://example.com/search"));
        call.setOperationName("searchDetails");

        Object[] params = {searchCriteria};
        String response = (String) call.invoke(params);

        System.out.println("Received response from server for criteria: " + searchCriteria);
        return response;
    }

    public static void main(String[] args) throws Exception {
        CachingClient client = new CachingClient();
        
        // Example usage
        System.out.println(client.getCachedResponse("exampleCriteria"));
        System.out.println(client.getCachedResponse("exampleCriteria")); // This should be cached
    }
}