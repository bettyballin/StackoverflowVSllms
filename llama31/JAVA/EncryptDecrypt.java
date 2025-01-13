import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class EncryptDecrypt {
    public static void main(String[] args) throws Exception {
        String password = "mysecretpassword";
        String userName = "myusername";

        // Generate a secret key
        Key key = new SecretKeySpec("mysecretkey".getBytes(), "AES");

        // Encrypt the user name and password
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedUserName = cipher.doFinal(userName.getBytes());
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());

        // Decrypt the user name and password
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedUserName = cipher.doFinal(encryptedUserName);
        byte[] decryptedPassword = cipher.doFinal(encryptedPassword);

        System.out.println("Encrypted user name: " + new String(encryptedUserName));
        System.out.println("Encrypted password: " + new String(encryptedPassword));
        System.out.println("Decrypted user name: " + new String(decryptedUserName));
        System.out.println("Decrypted password: " + new String(decryptedPassword));
    }
}