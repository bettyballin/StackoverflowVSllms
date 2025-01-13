import java.lang.String;

public class EmailValidatorTest {
    public static void main(String[] args) {
        String email = "example@example.com";
        if (EmailValidator.isValidEmail(email)) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email is not valid");
        }
    }
}