/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Main_280 {
    public static void main(String[] stringArray) {
        try {
            Socket socket = new Socket("www.google.com", 80);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            InputStream inputStream = socket.getInputStream();
            socket.setSoTimeout(5000);
            printStream.print("GET / HTTP/1.0\r\n\r\n");
            printStream.flush();
            socket.shutdownOutput();
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = false;
            while (!bl) {
                try {
                    int n = inputStream.read();
                    if (n == -1) {
                        bl = true;
                        continue;
                    }
                    stringBuilder.append((char)n);
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    bl = true;
                }
            }
            System.out.println(stringBuilder.toString());
        }
        catch (IOException iOException) {
            System.err.println("Error: " + iOException.getMessage());
        }
    }
}
