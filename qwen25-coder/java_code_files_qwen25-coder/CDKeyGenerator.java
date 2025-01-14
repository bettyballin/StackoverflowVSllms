import java.lang.String;
import java.security.SecureRandom;

public class CDKeyGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String CHAR_POOL = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ"; // Exclude '0', '1', 'O', 'I' to avoid confusion
    private static final int PRODUCT_CODE_LENGTH = 4;
    private static final int RESSELLER_CODE_LENGTH = 4;
    private static final int UNIQUE_KEY_LENGTH = 12;
    private static final int CHECKSUM_LENGTH = 2;

    public static String generateCDKey(String productCode, String resellerCode) {
        if (productCode.length() != PRODUCT_CODE_LENGTH || resellerCode.length() != RESSELLER_CODE_LENGTH) {
            throw new IllegalArgumentException("Product and reseller codes must be of correct length");
        }
        
        String uniqueSegment = generateRandomString(UNIQUE_KEY_LENGTH - CHECKSUM_LENGTH);
        char checksum = calculateChecksum(uniqueSegment);

        return productCode + "-" + resellerCode + "-" + uniqueSegment + checksum;
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }

    private static char calculateChecksum(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += CHAR_POOL.indexOf(c);
        }
        // Simple modulo operation to fit into a single character
        return CHAR_POOL.charAt(sum % CHAR_POOL.length());
    }

    public static boolean isValidKey(String key) {
        String[] parts = key.split("-");
        if (parts.length != 3 || 
            parts[0].length() != PRODUCT_CODE_LENGTH ||
            parts[1].length() != RESSELLER_CODE_LENGTH ||
            parts[2].length() != UNIQUE_KEY_LENGTH) {
            return false;
        }
        
        String uniqueSegment = parts[2].substring(0, UNIQUE_KEY_LENGTH - CHECKSUM_LENGTH);
        char providedChecksum = parts[2].charAt(UNIQUE_KEY_LENGTH - 1);
        char calculatedChecksum = calculateChecksum(uniqueSegment);

        return providedChecksum == calculatedChecksum;
    }

    public static void main(String[] args) {
        String productCode = "384A";
        String resellerCode = "GTLD";

        String cdKey = generateCDKey(productCode, resellerCode);
        System.out.println("Generated CD Key: " + cdKey);

        boolean valid = isValidKey(cdKey);
        System.out.println("Is CD Key Valid? " + valid);
    }
}