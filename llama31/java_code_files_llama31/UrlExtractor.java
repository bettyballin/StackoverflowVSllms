/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.util.Optional;

public class UrlExtractor {
    private URL extractUrl(Element element) throws Exception {
        return Optional.ofNullable(element).map(this::extractUrlHelper).orElse(null);
    }

    private URL extractUrlHelper(Element element) {
        return null;
    }

    public static void main(String[] stringArray) {
        UrlExtractor urlExtractor = new UrlExtractor();
        Element element = new Element();
        try {
            URL uRL = urlExtractor.extractUrl(element);
            System.out.println(uRL);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
