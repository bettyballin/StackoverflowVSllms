import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;

public class Crypto {
  private SecretKey secret = null;
  public void setKey(String myKey) {
    try {
      KeyGenerator kg = KeyGenerator.getInstance("AES");
      SecureRandom secureRandom = new SecureRandom((myKey).getBytes());
      kg.init(128, secureRandom);
      secret = kg.generateKey();
      kg = null;
    } catch (Exception e) {
      System.out.println("Failed to initialize the key generator: ");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
  }
}