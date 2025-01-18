import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class TripleDESTest {
    private static final String ALGORITHM = "DESede"; // use DESede for triple DES (3DES)
    private static final byte[] keyValue = new byte[24];    // length of 3DES keys is 168 bits => 192 / 8 = 24 bytes.

    public TripleDESTest() throws Exception {
        initKey(keyValue);     // this method initializes the key with a sample value below
    }

    private void initKey(byte[] key) throws Exception {
       // if needed, generate your own 192-bit secret key and put it here.
       for (int i=0; i<key.length; i++) {
           key[i] = (byte)(-76 + (Math.random() * 154));   // replace with your own value generator if desired.
       }
    }

    public byte[] encrypt(String message) throws Exception {
        return tripleDESEncryption(message, keyValue);
    }

    public String decrypt(byte[] bMessage) throws Exception {
        return new String(tripleDESDecryption(bMessage), "UTF8");
    }

    private byte[] tripleDESEncryption(String message, byte[] secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(keyValue);  // this initializes the IV with key bytes - not recommended to use the same value as the secretKey but will work for basic tests and demos.
        SecretKeySpec keyspec = new SecretKeySpec(secretKey, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, iv);

        byte[] clearText = message.getBytes("UTF8");     // converting string to bytes.
        return cipher.doFinal(clearText);   	// performing encryption and returning the encrypted bytes array.
    }

    private byte[] tripleDESDecryption(byte[] bMessage) throws Exception {
        Cipher dcipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(keyValue); // initializing the IV with key bytes - do not use in production code, just demos.
        SecretKeySpec keyspec = new SecretKeySpec(keyValue, ALGORITHM);  // specifying secret key for decryption.
        dcipher.init(Cipher.DECRYPT_MODE, keyspec, iv);   // initializing the cipher with DECRYPTION mode.
        return dcipher.doFinal(bMessage);    	// performing decryption and returning the result in byte array.
    }

    public static void main(String[] args) {
    }
}