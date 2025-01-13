/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class CustomRMISocketFactory
extends RMISocketFactory {
    private int minPort;
    private int maxPort;

    public CustomRMISocketFactory(int n, int n2) {
        this.minPort = n;
        this.maxPort = n2;
    }

    @Override
    public Socket createSocket(String string, int n) throws IOException {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress(this.minPort));
        socket.connect(new InetSocketAddress(string, n));
        return socket;
    }

    @Override
    public ServerSocket createServerSocket(int n) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(this.minPort));
        return serverSocket;
    }

    public static void main(String[] stringArray) {
    }
}
