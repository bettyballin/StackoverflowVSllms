import java.lang.String;

public class AsciiConverter {
    public static void main(String[] args) {
        byte[] temps = new byte[] { 0x74, 0x65, 0x73, 0x74 };
        String foo = new String(temps, java.nio.charset.StandardCharsets.US_ASCII);
        System.out.print(foo);
    }
}