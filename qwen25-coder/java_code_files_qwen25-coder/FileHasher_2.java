import java.lang.String;
// Example in Java using MD5
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHasher_2 {
    public static byte[] createChecksum(String filename) throws Exception {
        MessageDigest complete = MessageDigest.getInstance("MD5");
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        byte[] b = complete.digest(bytes);
        return b;
    }

	public static void main(String[] args) {
	}
}