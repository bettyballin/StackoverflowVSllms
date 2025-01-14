import java.lang.String;
import java.io.IOException;

public class FileSignAndEncrypt {
    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = "example.txt";
        String encryptedFilePath = "example.gpg";

        // Sign and encrypt the file using GnuPG
        ProcessBuilder pb = new ProcessBuilder("gpg", "--encrypt", "--sign", 
                                             "--recipient", "[Recipient's Email]", 
                                             "--output", encryptedFilePath, filePath);

        Process p = pb.start();
        p.waitFor();

        System.out.println("File signed and encrypted successfully.");
    }
}