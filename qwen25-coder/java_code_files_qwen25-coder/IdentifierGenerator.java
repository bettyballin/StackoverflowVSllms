import java.lang.String;
import java.security.SecureRandom;

public class IdentifierGenerator {
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private SecureRandom secureRandom = new SecureRandom();

    public String generateIdentifier(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(CHAR_SET.length());
            stringBuilder.append(CHAR_SET.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IdentifierGenerator identifierGenerator = new IdentifierGenerator();
        System.out.println("Generated ID: " + identifierGenerator.generateIdentifier(3)); // Example for 3 characters
    }
}