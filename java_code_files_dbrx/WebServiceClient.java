import java.util.HashMap;
import java.util.Map;

public class WebServiceClient {
    private Map<String, String> cache = new HashMap<>();

    public String search(String criteria) throws Exception {
        String result;
        // Check if result is cached
        if ((result = cache.get(criteria)) != null) return result;

        // Result was not in the cache, hit the server
        WebService service = new WebServiceServiceLocator().getWebService();
        result = service.searchDetail(criteria);

        // Cache the result and return it
        Integer maxCacheSize = 10_000; // Or whatever fits your memory constraints
        if (cache.size() >= maxCacheSize) {
            cache.clear(); // Evict all entries when we reach maximum size
        }
        cache.put(criteria, result); // Cache the new entry
        return result;
    }

    public static void main(String[] args) throws Exception {
        WebServiceClient client = new WebServiceClient();
        System.out.println(client.search("testCriteria"));
    }
}

class WebServiceServiceLocator {
    public WebService getWebService() {
        return new WebService();
    }
}

class WebService {
    public String searchDetail(String criteria) {
        return "Result for criteria: " + criteria;
    }
}