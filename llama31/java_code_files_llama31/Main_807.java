/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main_807 {
    public static void main(String[] stringArray) {
        String string = "example.com";
        try {
            InetAddress inetAddress = InetAddress.getByName(string);
            if (inetAddress.getHostAddress().equals(string)) {
                System.out.println("It's an IP address");
            } else {
                System.out.println("It's a hostname");
            }
        }
        catch (UnknownHostException unknownHostException) {
            System.out.println("Invalid input");
        }
    }
}
