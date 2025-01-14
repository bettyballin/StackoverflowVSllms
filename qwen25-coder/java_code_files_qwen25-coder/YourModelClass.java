import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface StringLengthFieldValidator {
    String message();
    String minLength();
    String maxLength();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RegexFieldValidator {
    String message();
    String expression();
}

public class YourModelClass {

    private String name;

    @StringLengthFieldValidator(message = "Name must be between 5 and 60 characters",
                                minLength = "5", maxLength = "60")
    @RegexFieldValidator(
        message = "Name should not contain special characters like !, ?, #, $",
        expression = "^[a-zA-Z0-9 ]+$" // Only allows letters, numbers, and spaces
    )
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
    }
}