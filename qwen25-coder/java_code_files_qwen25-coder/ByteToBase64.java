import java.util.Base64;

public class ByteToBase64 {
    public static void main(String[] args) {
        // Example byte array, replace with your actual byte array
        byte[] byteArray = {
            /* insert your byte data here */
        };

        // Convert the byte array to a Base64 encoded string
        String base64String = Base64.getEncoder().encodeToString(byteArray);

        // Output the Base64 string
        System.out.println(base64String);
    }
}