import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class OTPVerifier {

    private static final int TIME_TOLERANCE_MINUTES = 5; // Define your time tolerance

    public static String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyMessage(String message, String password, long clientTime, String clientSuppliedVerificationKey) {
        // Convert current time to minutes and round down
        long serverTimeInMinutes = System.currentTimeMillis() / 1000 / 60;
        
        for (int i = -TIME_TOLERANCE_MINUTES; i <= TIME_TOLERANCE_MINUTES; i++) {
            long possibleClientTime = clientTime / 1000 / 60 + i;
            String verificationKey = hash(message + password + possibleClientTime);
            
            if (verificationKey.equals(clientSuppliedVerificationKey)) {
                return true; // Verification successful
            }
        }
        
        return false; // Verification failed
    }

    public static void main(String[] args) {
        String message = "Hello, Server!";
        String password = "securePassword";
        long clientTime = System.currentTimeMillis(); // Client's current time
        
        // Client side: Generate verification key with a rounded timestamp
        long timeInMinutes = (clientTime / 1000) / 60; // Simplified version of rounding to minutes
        String clientSuppliedVerificationKey = hash(message + password + timeInMinutes);
        
        // Server side: Verify message
        boolean isValid = verifyMessage(message, password, clientTime, clientSuppliedVerificationKey);
        System.out.println("Is the message valid? " + isValid);
    }
}