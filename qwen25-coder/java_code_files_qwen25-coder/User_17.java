import java.lang.String;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class User_17 {
    public final class User {

        @NotBlank(message = "{name.notBlank}")
        @Length(max = 80)
        private String name;

        @NotBlank(message = "{email.notBlank}")
        @Email(message = "{email.invalid}")
        @Length(max = 80, message = "{email.lengthViolation}")
        private String email;

        @NotBlank(message = "{text.notBlank}")
        @Length(max = 4000)
        private String text;
    }

    public static void main(String[] args) {
    }
}