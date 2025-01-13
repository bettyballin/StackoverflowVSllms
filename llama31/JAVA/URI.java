import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CustomURI {
    private final String scheme;
    private final String host;
    private String path;
    private String query;
    private List<String> queryParams = new ArrayList<>();

    public CustomURI(String uri) throws URISyntaxException {
        // Parse the URI string into its components
        URI parsedUri = new URI(uri);
        this.scheme = parsedUri.getScheme();
        this.host = parsedUri.getHost();
        this.path = parsedUri.getPath();
        this.query = parsedUri.getQuery();
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public void setPath(String path) {
        // Update the path component
        this.path = path;
    }

    public void addQueryParam(String key, String value) {
        // Add a query parameter
        queryParams.add(key + "=" + value);
        query = String.join("&", queryParams);
    }

    public static void main(String[] args) throws URISyntaxException {
        CustomURI customUri = new CustomURI("https://example.com/path?a=1&b=2");
        System.out.println("Scheme: " + customUri.getScheme());
        System.out.println("Host: " + customUri.getHost());
        System.out.println("Path: " + customUri.getPath());
        System.out.println("Query: " + customUri.getQuery());

        customUri.setPath("/newpath");
        customUri.addQueryParam("c", "3");
        System.out.println("Updated Path: " + customUri.getPath());
        System.out.println("Updated Query: " + customUri.getQuery());
    }
}