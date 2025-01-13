import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class UserIdValidator implements ConstraintValidator<UserId, Long> {

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        // custom validation logic
        return id > 0 && id < 100000;
    }
}

@Constraint(validatedBy = UserIdValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserId {
    String message() default "Invalid user id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class Main {
    public static void main(String[] args) {
    }
}