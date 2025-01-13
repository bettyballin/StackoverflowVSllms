import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Constraint(validatedBy = CustomValidator.class)
public @interface CustomConstraint {
    String message() default "Invalid input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class CustomValidator implements ConstraintValidator<CustomConstraint, String> {
    @Override
    public void initialize(CustomConstraint constraintAnnotation) {
        // Initialization is required
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        // custom validation logic
        return true; // Replace with your custom validation logic
    }

    public static void main(String[] args) {
    }
}