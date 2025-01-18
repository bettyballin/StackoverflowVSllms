import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class PasswordHasher {
    // Use this method as an example for hashing password with SHA-512 + Salt
    public static String hashPassword(String passwordToHash, String salt) {
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            Formatter formatter = new Formatter();
            for (byte b : bytes) {
                formatter.format("%04x", b);
            }
            sb.append(formatter.toString());
        } catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    }
}