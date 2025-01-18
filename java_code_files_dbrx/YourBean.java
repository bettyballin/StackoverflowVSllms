// Necessary imports
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Definition of @Named annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@interface Named {
    String value() default "";
}

// Definition of the Conversational annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Conversational {
    String[] conversation();
}

@Named
@Conversational(conversation = {"main", "additional conversation ids"})
public class YourBean implements Serializable {
    // Class body
}