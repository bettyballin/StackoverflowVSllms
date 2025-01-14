import java.net.URL;
import org.w3c.dom.Element;
import java.lang.annotation.*;

// Define the Nonnull annotation
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@interface Nonnull {
}

public class MyClass {
   public @Nonnull URL extractUrl(@Nonnull Element element) throws Exception {
      // rest of the code...
   }
}