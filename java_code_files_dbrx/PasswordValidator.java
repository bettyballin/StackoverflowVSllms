import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidator {
    String hashedPassword;
    boolean isValid = BCrypt.checkpw("enteredPassword", hashedPassword); // Returns true if the entered password matches the stored one, false otherwise

    public static void main(String[] args) {
    }
}