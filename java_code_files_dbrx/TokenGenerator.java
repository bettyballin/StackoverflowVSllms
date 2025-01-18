import java.lang.String;
import java.security.SecureRandom;
public class TokenGenerator {
  private SecureRandom rnd = new SecureRandom();
  public String generateToken() {
    return Long.toHexString(rnd.nextLong());
   }

	public static void main(String[] args) {
	}
}