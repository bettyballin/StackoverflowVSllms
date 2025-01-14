import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ProfiledAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Profiled {
        String value();
    }

    public static void main(String[] args) {
    }
}