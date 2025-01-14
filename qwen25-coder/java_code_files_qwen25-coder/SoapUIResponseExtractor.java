import java.lang.String;
import java.util.Base64;
import java.io.FileOutputStream;
import java.io.IOException;

public class SoapUIResponseExtractor {
    public static void main(String[] args) {
        // This is your Base64 encoded string from the SOAP response
        String base64String = "UEsDBBQACAAIAO1GNToAAAAAAAAAAAAAAAANAAAAc2NyaXB0cy9lbGxzaCBjb21tYW5kc1BLAQIUABQACAAIAO1GNTp8eBuZRAEAABMDAAAmAAAAAAAAAAAAAAAAAKJiAABsZGFwX25vZGVfY29uZmlndXJhdGlvbi9lbGxzaC1jb21tYW5kc1BLBQYAAAAABQAFAIgBAAA6ZAAAAAA="; // Replace with your actual base64 string

        try {
            // Decode the Base64 encoded string to byte array
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);

            // Write bytes to a file to verify if it's a zip file
            try (FileOutputStream fos = new FileOutputStream("extracted_file.zip")) {
                fos.write(decodedBytes);
            }

            System.out.println("The extracted file is: extracted_file.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}