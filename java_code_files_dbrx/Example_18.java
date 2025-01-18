import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

enum FetchType {
    EAGER,
    LAZY;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ManyToOne {
    FetchType fetch() default FetchType.EAGER;
}

public class Example {
    @ManyToOne(fetch = FetchType.LAZY)
    private Object someField;
}