import java.lang.String;
import javax.crypto.Cipher;
import java.security.Key;

public class EncryptionService {
      private final Key secretKey;

      public EncryptionService(Key key) {
          this.secretKey = key;
      }

      public byte[] encrypt(byte[] plaintext) throws Exception {
          Cipher cipher = Cipher.getInstance("AES");
          cipher.init(Cipher.ENCRYPT_MODE, secretKey);
          return cipher.doFinal(plaintext);
      }
}

class Main {
    public static void main(String[] args) {
    }
}