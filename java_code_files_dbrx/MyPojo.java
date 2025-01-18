import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface DynamicValidations {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

interface Payload {
}

@DynamicValidations(
    message = "The provided MyPojo object has some invalid values.",
    groups = {},
    payload = {}
)
public class MyPojo {
    private String myField; // The field to be validated dynamically at runtime.
}