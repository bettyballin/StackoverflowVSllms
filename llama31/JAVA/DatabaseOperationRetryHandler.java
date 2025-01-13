import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the @Retry annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Retry {
    int value();
}

public class DatabaseOperationRetryHandler {

    @Retry(3) // retry 3 times
    public void performDatabaseOperation() {
        // database code that might throw a deadlock exception
    }

    public static void main(String[] args) {
    }
}