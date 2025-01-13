import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

// Define a User class with annotations for validation
class User {
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(min = 1, max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main_105 {
    public static void main(String[] args) {
        // Create a validator factory
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        // Get a validator
        Validator validator = factory.getValidator();

        // Create an object to validate
        User user = new User();
        user.setName("John");

        // Validate the object
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // Print any violations
        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}