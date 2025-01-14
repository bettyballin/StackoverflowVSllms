import java.lang.String;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class Person_4 {
    public final class Person {

        @NotBlank(message = "{name.notBlank}")
        @Length(max = 80)
        private String name;

        @NotBlank(message = "{email.notBlank}")
        @Email(message = "{email.invalid}")
        @Length(max = 80, message = "{email.lengthViolation}")
        private String email;

        // Other fields...
    }
    
    public static void main(String[] args) {
    }
}