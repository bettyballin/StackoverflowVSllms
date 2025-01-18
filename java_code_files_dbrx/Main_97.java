import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Main {
  public static void main(String[] args) throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance("AES"); // Or "Rijndael"
    keyGen.init(128); // For example, to generate the equivalent of AES-128,
                      // i.e., Rijndael with 16 bytes block size and a key size of 16 bytes
    SecretKey secret = keyGen.generateKey();

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Or "Rijndael" mode if supported by JCE provider
    byte[] initVector = new byte[cipher.getBlockSize()]; // Initialization vector for the first plaintext block
    IvParameterSpec iv = new IvParameterSpec(initVector);
  }
}