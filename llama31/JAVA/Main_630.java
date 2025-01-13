import java.lang.String;
import java.lang.Integer;
public class Main_630 {
    public static void main(String[] args) {
        String ipAddress = "84.52.184.224";
        String[] octets = ipAddress.split("\\.");

        long ipLong = 0;
        for (int i = 0; i < 4; i++) {
            int octet = Integer.parseInt(octets[i]);
            ipLong |= (long) octet << (24 - i * 8);
        }

        String ipHex = Long.toHexString(ipLong);

        System.out.println("IP Address: " + ipAddress);
        System.out.println("Long: " + ipLong);
        System.out.println("Hex: " + ipHex);
    }
}