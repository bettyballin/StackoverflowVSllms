import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface NotNull {
    String message();
}

public class ValidationBean {

    private String firstName;

    @NotNull(message = "Name cannot be null") // validate not null property value
    public String getFirstName() { return firstName; }

    public static void main(String[] args) {
    }
}