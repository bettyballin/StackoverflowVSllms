import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher_4_4 {
    public static void main(String[] args) {
        String plainPassword = "mysecretpassword";
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

        // Later, when verifying the password...
        String candidatePassword = "mysecretpassword";
        if (BCrypt.checkpw(candidatePassword, hashedPassword)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}