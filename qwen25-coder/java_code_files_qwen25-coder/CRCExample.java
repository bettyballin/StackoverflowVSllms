import java.util.zip.CRC32;

public class CRCExample {
    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        crc32.update("Hello World!".getBytes());
        System.out.println(crc32.getValue());
    }
}