import java.lang.String;
public class EmailValidator {
    public static boolean isValidEmailLength(String email) {
        return email.length() <= 254;
    }

    public static void main(String[] args) {
        String email = "example@domain.com";
        System.out.println("Is the email address length valid? " + isValidEmailLength(email));
    }
}