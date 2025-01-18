import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingExample {
    public static void main(String[] args) {
        String myPwd = "my secret password";
        String salt = BCrypt.gensalt();  // generates a random salt
        String hashedPwd = BCrypt.hashpw(myPwd, salt);

        System.out.println("Plain Password: " + myPwd);
        System.out.println("Generated Salt: " + salt);
        System.out.println("Hashed Password: " + hashedPwd);
    }
}