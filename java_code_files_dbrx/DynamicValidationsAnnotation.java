import java.lang.String;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DynamicValidationsAnnotation {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = DynamicValidator.class)
    public @interface DynamicValidations {
        String message() default "";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }

    public static void main(String[] args) {
    }
}

@interface Constraint {
    Class<?>[] validatedBy();
}

interface Payload {
}

class DynamicValidator {
}