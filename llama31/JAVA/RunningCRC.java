import java.util.zip.CRC32;

public class RunningCRC {
    public static int computeCRC32(byte[] data, int crc) {
        // CRC32 implementation...
        // For example, using the java.util.zip.CRC32 class:
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return (int) crc32.getValue() ^ crc;
    }

    public static void main(String[] args) {
        int crc = 0;
        crc = computeCRC32("abcdef".getBytes(), crc);
        crc = computeCRC32("ghijkl".getBytes(), crc);
        System.out.println(crc);
    }
}