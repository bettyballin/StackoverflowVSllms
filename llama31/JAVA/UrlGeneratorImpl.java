import java.lang.String;

// presentation-layer module
interface UrlGenerator {
    String generateUrl(String path);
}

public class UrlGeneratorImpl implements UrlGenerator {
    @Override
    public String generateUrl(String path) {
        // Use presentation layer's URL generation logic here
        return "/base-path/" + path;
    }

    public static void main(String[] args) {
        UrlGeneratorImpl urlGenerator = new UrlGeneratorImpl();
        System.out.println(urlGenerator.generateUrl("test"));
    }
}