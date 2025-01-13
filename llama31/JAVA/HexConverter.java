import java.lang.String;

public class HexConverter {
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x ", b));
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
    }
}