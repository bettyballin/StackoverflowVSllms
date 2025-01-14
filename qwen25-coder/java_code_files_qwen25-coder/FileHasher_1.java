import java.lang.String;
// Example in Java using SHA-256
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHasher_1 {
    public static byte[] createChecksum(String filename) throws Exception {
        MessageDigest complete = MessageDigest.getInstance("SHA-256");
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        byte[] b = complete.digest(bytes);
        return b;
    }

	public static void main(String[] args) {
	}
}