import java.io.IOException;
import java.net.URL;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class URLFetcher {

    public String fetchURL(String urlString) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Map<String, List<String>> getQueryParams(URL url) throws IOException {
        Map<String, List<String>> queryPairs = new LinkedHashMap<>();
        String query = url.getQuery();
        if (query == null) {
            return queryPairs;
        }
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8) : pair;
            String value = idx > 0 && pair.length() > idx + 1 ?
                    URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8) : null;
            queryPairs.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
        return queryPairs;
    }

    public List<String> getPathSegments(URL url) {
        var path = url.getPath();
        if (path.startsWith("/")) {
            // Remove leading slash
            path = path.substring(1);
        }
        return new ArrayList<>(List.of(path.split("/")));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        URLFetcher fetcher = new URLFetcher();

        URL cleanUrl = new URL("http://example.com/hello/world");
        System.out.println("Clean URL Path Segments: " + fetcher.getPathSegments(cleanUrl));

        URL dirtyUrl = new URL("http://example.com/?action=hello&sub=world");
        Map<String, List<String>> queryParams = fetcher.getQueryParams(dirtyUrl);
        System.out.println("Dirty URL Query Params: " + queryParams);

        // Fetch content from URLs (for demonstration)
        String cleanData = fetcher.fetchURL(cleanUrl.toString());
        System.out.println("Clean URL Content: " + cleanData);  // Assume content handling for path

        String dirtyData = fetcher.fetchURL(dirtyUrl.toString());
        System.out.println("Dirty URL Content: " + dirtyData);
    }
}