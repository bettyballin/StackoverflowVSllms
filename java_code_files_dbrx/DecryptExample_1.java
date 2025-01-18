import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DecryptExample {
    public static void main(String[] args) throws Exception {
        // Your encryption key known only to your service & game app not exposed over network or embedded within the executable itself.
        byte[] keySym = null; 
        
        // The key code entered by the user.
        String keyCode = null; 

        SecretKeySpec aesKey = new SecretKeySpec(keySym, "AES");  // Your encryption key.
        Cipher decrypter = Cipher.getInstance("AES/CBC/PKCS7Padding", "SunJCE");
        decrypter.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] inputBack = decrypter.doFinal(Base64.getDecoder().decode(keyCode));  // Returns original string from 'key code' entered by user.
        
        // If you want to display the decrypted string:
        String originalString = new String(inputBack, "UTF-8");
        System.out.println("Decrypted string: " + originalString);
    }
}