import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class WikipediaImageURLGenerator {
    public static void main(String[] args) throws Exception {
        String baseUrl = "https://upload.wikimedia.org/wikipedia/commons/";
        String filename = "Example_Image.jpg"; // Replace with your actual filename
        filename = filename.replace(' ', '_');

        // Calculate XX and XF (first two and third characters of MD5 hash)
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(filename.getBytes(StandardCharsets.UTF_8));

        // Convert byte array to hex string
        String hash = bytesToHex(digest);

        String xx = hash.substring(0, 2);
        String xf = hash.substring(2, 3);

        String imageUrl = baseUrl + xx + "/" + xf + "/" + filename;
        System.out.println("Image URL: " + imageUrl);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}