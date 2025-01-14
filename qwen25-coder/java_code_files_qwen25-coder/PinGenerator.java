import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class PinGenerator {
    private static final SecureRandom random = new SecureRandom();
    private Set<String> issuedPins = new HashSet<>();

    public String generateUniquePin() {
        String pin;
        do {
            int randomNumber = 10000000 + random.nextInt(90000000);
            pin = String.valueOf(randomNumber);
        } while (!issuedPins.add(pin)); // Add returns false if the pin already exists
        return pin;
    }

    public static void main(String[] args) {
        PinGenerator generator = new PinGenerator();
        for (int i = 0; i < 100000; i++) { // Generate pins for 100,000 users
            System.out.println(generator.generateUniquePin());
        }
    }
}