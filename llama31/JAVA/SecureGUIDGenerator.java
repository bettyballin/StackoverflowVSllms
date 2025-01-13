import java.lang.String;
import java.security.SecureRandom;
import java.util.UUID;

public class SecureGUIDGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static UUID generateGUID() {
        byte[] bytes = new byte[16];
        secureRandom.nextBytes(bytes);
        return UUID.nameUUIDFromBytes(bytes);
    }

	public static void main(String[] args) {
	}
}