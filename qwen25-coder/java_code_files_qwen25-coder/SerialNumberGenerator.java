import java.lang.String;
import java.security.SecureRandom;

public class SerialNumberGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int PART_LENGTH = 5;
    private static final int TOTAL_PARTS = 5;

    public static void main(String[] args) {
        System.out.println("Generated Serial Number: " + generateSerialNumber());
    }

    /**
     * Generates a serial number with specified parts and characters.
     * @return the generated serial number as a String
     */
    public static String generateSerialNumber() {
        StringBuilder serial = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < TOTAL_PARTS; i++) {
            for (int j = 0; j < PART_LENGTH; j++) {
                int index = random.nextInt(CHARACTERS.length());
                serial.append(CHARACTERS.charAt(index));
            }
            if (i < TOTAL_PARTS - 1) {
                serial.append('-');
            }
        }

        return serial.toString();
    }
}