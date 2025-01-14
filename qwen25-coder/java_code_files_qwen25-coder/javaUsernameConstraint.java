import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class javaUsernameConstraint {
    // Example of a simple validation constraint in Hibernate Validator
    @Constraints.Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", message = "Username must be between 6 and 12 characters")
    private String username;
    public static void main(String[] args) {
    }
}

class Constraints {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Pattern {
        String regexp();
        String message();
    }
}