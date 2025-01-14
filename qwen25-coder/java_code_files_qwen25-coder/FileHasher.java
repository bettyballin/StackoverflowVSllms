import java.lang.String;
// Example in Java using CRC32
import java.util.zip.CRC32;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHasher {
    public static long createChecksum(String filename) throws Exception {
        CRC32 crc = new CRC32();
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        crc.update(bytes);
        return crc.getValue();
    }

	public static void main(String[] args) {
	}
}