import java.lang.String;
import java.security.SecureRandom;

public class PinGenerator {
    public static String generatePin(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder pin = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            pin.append(random.nextInt(10)); // 0-9
        }
        return pin.toString();
    }

	public static void main(String[] args) {
	}
}