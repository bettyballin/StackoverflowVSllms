import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class OurResourcesBundle {

    public interface ClientBundle {
        // Interface methods can be defined here if needed.
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Source {
        String value();
    }

    public interface TextResource {
        // Method to retrieve the text content.
        String getText();
    }

    public interface OurResources extends ClientBundle {
        @Source("ourhtml.html?versionStr")
        TextResource ourHtml();
    }

    public static void main(String[] args) {
        // Main method implementation.
    }
}