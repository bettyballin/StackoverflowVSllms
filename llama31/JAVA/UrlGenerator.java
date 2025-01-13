// Define the interface in a separate file or rename the class/interface to avoid conflict
public interface UrlGeneratorInterface {
    String generateUrl(String path);
}

public class UrlGenerator {
    // url-generator-api module
    public static void main(String[] args) {
        // Implement the interface to use it
        UrlGeneratorInterface urlGenerator = new UrlGeneratorInterface() {
            @Override
            public String generateUrl(String path) {
                // Implement the logic to generate the URL
                return "Generated URL: " + path;
            }
        };
        
        // Example usage
        String url = urlGenerator.generateUrl("example/path");
        System.out.println(url);
    }
}