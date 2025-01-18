import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import java.io.ByteArrayOutputStream;
import java.util.zip.CRC32;
import java.io.IOException;
import com.google.common.primitives.Longs;

public class Main {
    public static byte[] getCRC32File(byte[] input) {
        CheckedOutputStream cos = new CheckedOutputStream(new ByteArrayOutputStream(), new CRC32());
        try {
            cos.write(input);
        } catch (IOException e) {
            throw new RuntimeException("Error calculating checksum", e);
        }
        return Longs.toByteArray(((CRC32) cos.getChecksum()).getValue());
    }
}