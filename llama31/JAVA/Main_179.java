import org.mindrot.jbcrypt.BCrypt;

public class Main_179 {
    public static void main(String[] args) {
        // Hash the password
        String password = "mysecretpassword";
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);

        System.out.println("Hashed Password: " + hashedPassword);
    }
}