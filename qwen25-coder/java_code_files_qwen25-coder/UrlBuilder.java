import java.net.URI;

public class UrlBuilder {
    // Using path segments
    String x = "xValue";
    String y = "yValue";
    String z = "zValue";

    String urlPath = "http://myservice.example.com/service/" + x + "/" + y + "/" + z;
    String resourceUri;

    // Using query parameters
    String queryString = String.format("x=%s&y=%s&z=%s", x, y, z);
    String fullUrlWithParams = "http://myservice.example.com/service?" + queryString;
    URI resourceUriWithQueryParameters;
    
    public UrlBuilder() {
        try {
            resourceUri = new URI(urlPath).toString();
            resourceUriWithQueryParameters = new URI(fullUrlWithParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new UrlBuilder();
    }
}