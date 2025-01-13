import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URIBuilder {
    private StringBuilder queryString;

    public URIBuilder() {
        queryString = new StringBuilder();
    }

    public URIBuilder addParameter(String name, String value) {
        if (queryString.length() > 0) {
            queryString.append("&");
        }
        try {
            queryString.append(URLEncoder.encode(name, StandardCharsets.UTF_8.toString()))
                    .append("=")
                    .append(URLEncoder.encode(value, StandardCharsets.UTF_8.toString()));
        } catch (Exception e) {
            // Handle exception
        }
        return this;
    }

    public URI build() {
        try {
            return new URI("?" + queryString.toString());
        } catch (URISyntaxException e) {
            // Handle exception
            return null;
        }
    }

    public static void main(String[] args) {
        URIBuilder builder = new URIBuilder();
        String queryString = builder
                .addParameter("username", "john")
                .addParameter("password", "123")
                .build().toString();
        System.out.println(queryString);
    }
}