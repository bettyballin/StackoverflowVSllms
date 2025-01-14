import java.lang.String;
public class SimpleMAC {
    public static String generateMAC(String businessDataId, String userId) {
        // Concatenate the input strings
        String data = businessDataId + userId;
        
        // Generate a very simple hash using XOR
        int hash = 0;
        for (char c : data.toCharArray()) {
            hash ^= ((int) c);
        }
        
        // Convert hash to an absolute value and limit to 2 characters
        return String.format("%02X", Math.abs(hash % 256));
    }

    public static void main(String[] args) {
        String businessDataId = "12345";
        String userId = "userA";
        
        String mac = generateMAC(businessDataId, userId);
        System.out.println("Generated MAC: " + mac);
    }
}