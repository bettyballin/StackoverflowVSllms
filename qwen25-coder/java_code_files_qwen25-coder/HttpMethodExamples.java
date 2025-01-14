import java.lang.String;
// Example of using HTTP methods in Java with a hypothetical client

public class HttpMethodExamples {

    private HttpClient httpClient;

    public void fetchResource(String url) {
        // Using GET to retrieve a resource
        httpClient.get(url);
    }

    public void createResource(String url, String data) {
        // Using POST to create a new resource
        httpClient.post(url, data);
    }

    public void updateResource(String url, String data) {
        // Using PUT to update an existing resource
        httpClient.put(url, data);
    }

    public void deleteResource(String url) {
        // Using DELETE to remove a resource
        httpClient.delete(url);
    }

    public ResourceMetaData getResourceInfo(String url) {
        // Using HEAD to get metadata about the resource without downloading it
        return httpClient.head(url);
    }

    public static void main(String[] args) {
    }
}

class HttpClient {
    public void get(String url) {}
    public void post(String url, String data) {}
    public void put(String url, String data) {}
    public void delete(String url) {}
    public ResourceMetaData head(String url) { return null; }
}

class ResourceMetaData {
}