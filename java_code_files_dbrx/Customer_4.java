import java.lang.String;
import java.io.Serializable;

public class Customer implements Serializable {
    // Empty implementation
}

// The input 'Customer' instance of our validation method
public class Customer_4 extends Customer {
    // Empty implementation
}

// Validator for customers. Note that it should implement `AbstractValidator<Customer>`, otherwise, you will encounter casting errors
abstract class AbstractValidator<T> {
    // Empty implementation or abstract methods
}

public class Customer_4Validator extends AbstractValidator<Customer> {
    public Customer_4Validator() {
        // Any constructor implementation would suffice...
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}