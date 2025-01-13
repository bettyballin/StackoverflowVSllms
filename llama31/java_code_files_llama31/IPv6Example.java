/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class IPv6Example {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress(InetAddress.getByName("::1"), 8080));
        socket.connect(new InetSocketAddress(InetAddress.getByName("2001:0db8:85a3:0000:0000:8a2e:0370:7334"), 8080));
    }
}
