import java.lang.String;
import java.util.Base64;

public class EmbeddedTextFile {

    // Base64 encoded version of your text file
    private static final String TEXT_FILE_BASE64 = 
        "RVZFTkQgVEhFIFRFWFQgRkVMTE9VRSBUSEVSUywgTkFORCBFTkNPREUgaXQgd2l0aCAK" +
        "YmFzZTY0LgpUaGFua3M6IHRvZGEudGVjaEBleGFtcGxlLmNvbQo="; // This is a dummy base64 string

    public static void main(String[] args) {
        // Decode the base64 string back to original byte array
        byte[] decodedBytes = Base64.getDecoder().decode(TEXT_FILE_BASE64);

        // Convert bytes to string
        String textFileContent = new String(decodedBytes);

        // Print or use the content as needed
        System.out.println(textFileContent);
    }
}