public class Main {
    public static void main(String[] args) {
        byte[] byteArray = { 0, 1 }; // Your binary data with null characters
        String base64EncodedData = java.util.Base64.getEncoder().encodeToString(byteArray);
        // Use 'base64EncodedData' in your XML document as needed
        System.out.println(base64EncodedData);
    }
}