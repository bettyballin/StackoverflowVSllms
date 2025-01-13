import java.util.zip.CRC32;

public class Main_66 {
    public static void main(String[] args) {
        CRC32 crc = new CRC32();
        char[] unsignedCharArray = "Hello, World!".toCharArray();
        crc.update(String.valueOf(unsignedCharArray).getBytes());
        long crcValue = crc.getValue();
        System.out.println(crcValue);
    }
}