import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class ProfiledAnnotation {
    @Target(ElementType.METHOD) @Retention(RUNTIME) // Add this line to set the retention policy = RUNTIME
    public @interface Profiled { String value(); }

    public static void main(String[] args) {
    }
}