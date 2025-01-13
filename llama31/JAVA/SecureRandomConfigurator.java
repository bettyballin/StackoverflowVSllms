import java.net.URL;
import java.security.SecureRandom;

public class SecureRandomConfigurator {
    public static void main(String[] args) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom = new SecureRandom(new URL("file:/dev/urandom").openStream());
    }
}