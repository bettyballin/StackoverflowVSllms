import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        // Assuming 'encodedData' is a Base64 encoded string
        String encodedData = "SGVsbG8gV29ybGQh"; // "Hello World!" in Base64

        // Decode the Base64 encoded data
        byte[] decodedData = Base64.getDecoder().decode(encodedData);

        String result = null;
        try {
            result = new String(decodedData, "UTF-8"); // assuming UTF-8 encoding
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Decoded string: " + result);
    }
}