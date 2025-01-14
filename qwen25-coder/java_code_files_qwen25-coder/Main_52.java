// To compile this code, you need to include the Java Bean Validation API and its implementation (e.g., Hibernate Validator) in your classpath.

import javax.validation.constraints.Email;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

class EmailValidationExample {
    @Email
    private String email;

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        EmailValidationExample example = new EmailValidationExample();
        example.setEmail("example@example.com");

        Set<ConstraintViolation<EmailValidationExample>> violations = validator.validate(example);
        boolean isValid = violations.isEmpty();
        System.out.println("Is the email valid? " + isValid);
    }
}