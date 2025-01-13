/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main_441 {
    public static void main(String[] stringArray) {
        try {
            String string = InetAddress.getLocalHost().getHostAddress();
            InetAddress inetAddress = InetAddress.getByName(string);
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
            byte[] byArray = networkInterface.getHardwareAddress();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte by : byArray) {
                stringBuilder.append(String.format("%02X:", by));
            }
            String string2 = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println("IP Address: " + string);
            System.out.println("MAC Address: " + string2);
        }
        catch (SocketException | UnknownHostException iOException) {
            System.err.println("Error: " + iOException.getMessage());
        }
    }
}
