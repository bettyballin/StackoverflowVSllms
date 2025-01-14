import java.nio.charset.StandardCharsets;

public class HexToAscii {
    public static void main(String[] args) {
        byte temps[] = new byte[4];

        temps[0] = 0x74;
        temps[1] = 0x65;
        temps[2] = 0x73;
        temps[3] = 0x74;

        String foo = new String(temps, StandardCharsets.US_ASCII);
        System.out.print(foo);
    }
}