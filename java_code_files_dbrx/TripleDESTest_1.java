import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TripleDESTest {
    private static final String ALGORITHM = "DESede";
    private static final byte[] keyValue = new byte[]{
            (byte)0x24, (byte)0x75, (byte)0xA2, (byte)0xB3,
            (byte)0xC5, (byte)0xD6, (byte)0xE7, (byte)0xF8,
            (byte)0x24, (byte)0x75, (byte)0xA2, (byte)0xB3,
            (byte)0xC5, (byte)0xD6, (byte)0xE7, (byte)0xF8,
            (byte)0x24, (byte)0x75, (byte)0xA2, (byte)0xB3,
            (byte)0xC5, (byte)0xD6, (byte)0xE7, (byte)0xF8
    };

    public static void main(String[] args) {
        try {
            TripleDESTest tdest = new TripleDESTest();          // initializing our encryption/decryption algorithm and key.
            String msg = "test";                               // creating a test message to encrypt.
            byte[] btext = tdest.encrypt(msg);                 // performing the actual encryption and storing it in an array of bytes.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // get input from user as part of this demo - replace with other methods as needed.
            System.out.println("Original " + msg);             // display original message (for testing and debugging purposes)
            System.out.print("Encrypted ");                    // just a label to identify the output line which follows next...
            for (int i = 0; i < btext.length; i++) {           // now we print out the result in encrypted form
                System.out.print(btext[i] + " ");              // printing every byte
            }
            String ptext = tdest.decrypt(btext);               // decryption of the resulting string from our sample message above
            System.out.println("\nDecrypted " + ptext);        // displaying to console
        } catch (Exception e) {                                // don't forget the try/catch blocks when working with crypto
            System.out.println("Exception " + e);              // display error message or send an alert if any exception is encountered
        }                                                      // always close out your main() method in a clean manner!
    }

    public byte[] encrypt(String data) throws Exception {
        SecretKey key = new SecretKeySpec(keyValue, ALGORITHM);            // generate the secret key
        Cipher c = Cipher.getInstance(ALGORITHM);                          // get the cipher instance
        c.init(Cipher.ENCRYPT_MODE, key);                                  // initialize the cipher for encryption
        byte[] encVal = c.doFinal(data.getBytes(StandardCharsets.UTF_8));  // perform encryption
        return encVal;                                                     // return encrypted data
    }

    public String decrypt(byte[] encryptedData) throws Exception {
        SecretKey key = new SecretKeySpec(keyValue, ALGORITHM);            // generate the secret key
        Cipher c = Cipher.getInstance(ALGORITHM);                          // get the cipher instance
        c.init(Cipher.DECRYPT_MODE, key);                                  // initialize the cipher for decryption
        byte[] decValue = c.doFinal(encryptedData);                        // perform decryption
        String decryptedValue = new String(decValue, StandardCharsets.UTF_8);  // convert bytes to string
        return decryptedValue;                                             // return decrypted data
    }
}