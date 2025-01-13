import java.lang.String;
import java.security.SecureRandom;

public class PasswordGenerator {
  public static void main(String[] args) {
    SecureRandom random = new SecureRandom();
    byte[] passwordBytes = new byte[32]; // 256 bits of entropy
    random.nextBytes(passwordBytes);
    String password = bytesToHex(passwordBytes);
    System.out.println(password);
  }

  private static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
}