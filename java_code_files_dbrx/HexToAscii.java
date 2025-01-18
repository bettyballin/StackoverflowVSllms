import java.lang.String;
public class HexToAscii {
    public static void main(String[] args) {
        // Array to hold hex values (0x74 = 't', 0x65 = 'e', 0x73 = 's', 0x74 = 't')
        byte temps[] = new byte[4];

        temps[0] = (byte) 0x74; // 't'
        temps[1] = (byte) 0x65; // 'e'
        temps[2] = (byte) 0x73; // 's'
        temps[3] = (byte) 0x74; // 't'

        String foo = new String(temps); // Convert hex values to string

        System.out.println(foo); // Print the resulting string, which is "test"
    }
}