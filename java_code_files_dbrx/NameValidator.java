import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExpressionValidator {
    String message();
    String key();
    String expression();
}

public class NameValidator {
    private String name;

    @ExpressionValidator(
        message = "Name must not contain special characters",
        key = "name.specialchars",
        expression = "!value.matches(\"[^a-zA-Z0-9\\\\s]+\")"
    )
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
    }
}