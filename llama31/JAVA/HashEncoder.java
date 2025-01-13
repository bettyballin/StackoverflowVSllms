import java.lang.String;

public class HashEncoder {
    byte[] sha1Bytes = new byte[] { (byte) 0x9a, (byte) 0x81, (byte) 0x33, (byte) 0x3c, (byte) 0x1b, (byte) 0x16, (byte) 0xe4, (byte) 0xa8, (byte) 0x3c, (byte) 0x10, (byte) 0xf3, (byte) 0x05, (byte) 0x2c, (byte) 0x15, (byte) 0x90, (byte) 0xaa, (byte) 0xdf, (byte) 0x5e, (byte) 0x2e, (byte) 0x20 };
    String encodedString = encodeByteArray(sha1Bytes);

    public static void main(String[] args) {
        HashEncoder encoder = new HashEncoder();
        System.out.println(encoder.encodedString);
    }

    public static String encodeByteArray(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}