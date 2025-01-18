import java.lang.annotation.*;

enum VersionStatus {
    CURRENT,
    DEPRECATED,
    OBSOLETE
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Versioned {
    String version();
    VersionStatus status();
}

@Versioned(version = "1", status = VersionStatus.CURRENT)
public class Example {
    public static void main(String[] args) {
        System.out.println("Example class with @Versioned annotation.");
    }
}