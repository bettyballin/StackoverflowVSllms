/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;

public class PortScanner {
    public static void main(String[] stringArray) {
        String string = "192.168.1.100";
        int n = 1521;
        try {
            Socket socket = new Socket(string, n);
            System.out.println(string + " is listening on port " + n);
            socket.close();
        }
        catch (Exception exception) {
            System.out.println(string + " is not listening on port " + n);
        }
    }
}
