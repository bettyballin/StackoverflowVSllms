import java.lang.String;
import java.lang.Integer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "YourInputString"; // Replace with your actual data
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        System.out.println("SHA-256 Hash: " + hexString.toString());
    }
}