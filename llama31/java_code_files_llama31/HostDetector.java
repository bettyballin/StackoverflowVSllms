/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostDetector {
    public static void main(String[] stringArray) {
        String string = "192.168.1.";
        for (int i = 1; i <= 254; ++i) {
            String string2 = string + i;
            try {
                InetAddress inetAddress = InetAddress.getByName(string2);
                if (!inetAddress.isReachable(1000)) continue;
                System.out.println(string2 + " is reachable");
                continue;
            }
            catch (UnknownHostException unknownHostException) {
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }
}
