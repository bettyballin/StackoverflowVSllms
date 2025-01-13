import java.util.Base64;

public class Main_742 {
    public static void main(String[] args) {
        // Assuming some binary data for demonstration
        byte[] binaryData = "Hello, World!".getBytes();
        
        // Encode the binary data to Base64
        String encodedData = Base64.getEncoder().encodeToString(binaryData);
        
        // Print the encoded data
        System.out.println("Encoded Data: " + encodedData);
    }
}