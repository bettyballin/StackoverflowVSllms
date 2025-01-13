import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

public class ParallelRestInvoker {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Create Callable tasks for each REST endpoint
        Callable<JSONObject> taskA = () -> invokeRestEndpoint("http://serverA/endpoint");
        Callable<JSONObject> taskB = () -> invokeRestEndpoint("http://serverB/endpoint");
        Callable<JSONObject> taskC = () -> invokeRestEndpoint("http://serverC/endpoint");
        
        // Submit tasks and get Future objects
        Future<JSONObject> futureA = executor.submit(taskA);
        Future<JSONObject> futureB = executor.submit(taskB);
        Future<JSONObject> futureC = executor.submit(taskC);
        
        try {
            // Wait for each Future to complete with a 1-second timeout
            JSONObject resultA = futureA.get(1, TimeUnit.SECONDS);
            JSONObject resultB = futureB.get(1, TimeUnit.SECONDS);
            JSONObject resultC = futureC.get(1, TimeUnit.SECONDS);
            
            // Combine results into a single JSON object
            JSONObject combinedResult = new JSONObject();
            combinedResult.put("A", resultA);
            combinedResult.put("B", resultB);
            combinedResult.put("C", resultC);
            
            System.out.println(combinedResult.toString());
        } catch (TimeoutException e) {
            System.err.println("Timeout occurred while waiting for a response");
        } catch (Exception e) {
            System.err.println("Error invoking REST endpoints: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
    
    // Helper method to invoke a REST endpoint and return a JSONObject
    private static JSONObject invokeRestEndpoint(String url) {
        // Implement your REST invocation logic here (e.g., using OkHttp or Apache HttpClient)
        // Return a JSONObject representing the response
        // For demonstration purposes, return an empty JSONObject
        return new JSONObject();
    }
}