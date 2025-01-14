import java.security.SecureRandom;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.session.StandardManager;

public class CustomSessionIdLengthManager extends StandardManager {

    private static final SecureRandom random = new SecureRandom();

    @Override
    protected synchronized void startInternal() throws LifecycleException {
        super.startInternal();
        sessionIdLength = 20; // Set the desired session ID length here
    }

    @Override
    public String generateSessionId() {
        byte[] bytes = new byte[sessionIdLength];
        random.nextBytes(bytes);
        StringBuilder result = new StringBuilder(sessionIdLength * 2);
        for (byte b : bytes) {
            result.append(Character.forDigit((b & 0xf0) >> 4, 16));
            result.append(Character.forDigit(b & 0x0f, 16));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}