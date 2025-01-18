import java.util.HexFormat;

public class ByteStringConverter {
    private static String bytes2String(byte[] bytes) {
        return HexFormat.of().formatHex(bytes); // Available from Java 17 onwards
    }

    public static void main(String[] args) {
        byte[] bytes = { (byte)0x1A, (byte)0x2B, (byte)0x3C };
        System.out.println(bytes2String(bytes));
    }
}