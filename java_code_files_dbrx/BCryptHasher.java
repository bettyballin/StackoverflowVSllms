import org.mindrot.jbcrypt.BCrypt;

public class BCryptHasher {
    String myPwd = "my secret password";
    String salt = BCrypt.gensalt();  // generates a random salt for each user and DBMS instance
    String hashedPwdWithSalt = BCrypt.hashpw(salt + "$" + myPwd, BCrypt.gensalt());

    public static void main(String[] args) {
    }
}