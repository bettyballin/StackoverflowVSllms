// Custom exception class
class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

// Definitions of the annotations and enums
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Service {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Transactional {
    Propagation propagation() default Propagation.REQUIRED;
}

enum Propagation {
    REQUIRED
}

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class YourServiceClass {

    // Other members or methods can be added here

    public void changeBranch() throws DatabaseException {
        // Method implementation
    }
}