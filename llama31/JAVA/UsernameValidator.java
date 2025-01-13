import java.lang.String;

public class UsernameValidator {
    public static void main(String[] args) {
        try {
            // Code that might throw ConstraintViolationException
        } catch (javax.validation.ConstraintViolationException e) {
            throw new DuplicateUsernameException(e);
        }
    }
}

class DuplicateUsernameException extends Exception {
    public DuplicateUsernameException(Throwable cause) {
        super(cause);
    }
}