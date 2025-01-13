/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.ServerSocket;

public class Main_271 {
    public static void main(String[] stringArray) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        serverSocket.setSoTimeout(10000);
    }
}
