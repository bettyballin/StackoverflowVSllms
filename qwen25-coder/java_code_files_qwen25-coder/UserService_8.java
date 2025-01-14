import java.util.Set;

public class UserService_8 {
    private final Validator validator;

    public UserService_8(Validator validator) {
        this.validator = validator;
    }

    public void register(@Valid User user) throws ConstraintViolationException {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        // Proceed with registration logic
    }

    public static void main(String[] args) {
    }
}

// Define User class
class User {
    // User fields and methods
}

// Define @Valid annotation
@interface Valid {
}

// Define Validator interface
interface Validator {
    <T> Set<ConstraintViolation<T>> validate(T object);
}

// Define ConstraintViolation interface
interface ConstraintViolation<T> {
    // methods as needed
}

// Define ConstraintViolationException class
class ConstraintViolationException extends Exception {
    public ConstraintViolationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super();
    }
}