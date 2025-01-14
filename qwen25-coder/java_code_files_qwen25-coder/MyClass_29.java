import java.util.Optional;
import java.util.Objects;
import java.net.URL;
import org.w3c.dom.Element;

public class MyClass {
    public Optional<URL> extractUrl(Element element) throws Exception {
        Objects.requireNonNull(element, "element cannot be null");
        // logic to extract URL...
        URL url = null;
        return Optional.ofNullable(url);
    }
}