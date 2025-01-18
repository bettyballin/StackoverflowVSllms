import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import javax.json.*;
import java.net.http.HttpClient;

public class RestCaller {
    
    private Executor executor = Executors.newCachedThreadPool();
    
    JsonObject joinJson(List<JsonObject> jsons){
        // logic to combine json from all endpoints goes here
        return null; // Placeholder
    }
    
    public JsonObject callEndpointAndProcessResult(String u) throws Exception {
        // Placeholder implementation
        // assuming getJsonFromEndpoint performs REST request & returns json, replaced by actual method in OP's code
        return Json.createObjectBuilder().add("url", u).build();
    }
    
    public List<CompletableFuture<JsonObject>> callEndPointsAsync(String[] uri) {
        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
        return Arrays.stream(uri)
                    .map(u -> supplyAsync(() -> {
                         try{
                             return callEndpointAndProcessResult(u);
                         } catch(Exception ex){
                             // Handle Exception logic
                             return Json.createObjectBuilder().add("error", ex.toString()).build();
                         }
                    }, executor))
                .collect(Collectors.<CompletableFuture<JsonObject>>toList());
    }
    
    public JsonArray combineResults(List<CompletableFuture<JsonObject>> futures){
        // Completes each task asynchronously & combines all json object when tasks are done, exception handling for failed requests should also be handled here.
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        futures.forEach(future -> {
            JsonObject jsonObject = future.getNow(Json.createObjectBuilder().build());
            arrayBuilder.add(jsonObject);
        });
        return arrayBuilder.build();
    }
    
}