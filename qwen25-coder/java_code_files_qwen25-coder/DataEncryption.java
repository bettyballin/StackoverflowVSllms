import java.lang.String;
// Example of encrypting sensitive information in Java
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DataEncryption {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();

        Cipher aesCipherForEncryption = Cipher.getInstance("AES"); 
        aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey);

        String ssn = "123-45-6789"; // Example SSN
        byte[] byteDataToEncrypt = ssn.getBytes();
        byte[] byteCipherText = aesCipherForEncryption.doFinal(byteDataToEncrypt);
        
        System.out.println("Encrypted Data: " + new String(byteCipherText));
    }
}