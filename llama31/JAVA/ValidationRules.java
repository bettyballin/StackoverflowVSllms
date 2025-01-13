import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// ValidationRules.java (business layer)
public class ValidationRules {
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final int PASSWORD_MIN_LENGTH = 8;
}

// UserForm.java (presentation layer)
public class UserForm {
    @Pattern(regexp = ValidationRules.EMAIL_PATTERN)
    private String email;

    @Size(min = ValidationRules.PASSWORD_MIN_LENGTH)
    private String password;

    public static void main(String[] args) {
    }
}