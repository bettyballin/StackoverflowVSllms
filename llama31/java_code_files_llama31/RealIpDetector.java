/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RealIpDetector {
    public String getRealIp() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        }
        catch (UnknownHostException unknownHostException) {
            return null;
        }
    }

    public static void main(String[] stringArray) {
    }
}
