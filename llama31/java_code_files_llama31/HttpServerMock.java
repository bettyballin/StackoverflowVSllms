/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerMock {
    public static void main(String[] stringArray) {
        int n = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(n);
        }
        catch (IOException iOException) {
            System.out.println("ERROR: Could not listen on port: " + n);
            System.exit(-1);
        }
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        }
        catch (IOException iOException) {
            System.out.println("ERROR: Accept failed on port: " + n);
            System.exit(-1);
        }
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        }
        catch (IOException iOException) {
            System.out.println("ERROR: Could not get output stream");
            System.exit(-1);
        }
        printWriter.print("HTTP/1.1 200 OK\r\n");
        printWriter.print("Date: Thu, 05 Feb 2009 06:37:28 GMT\r\n");
        printWriter.print("Server: Apache\r\n");
        printWriter.print("Set-Cookie: Apache=99.245.58.244.1233815848703045; path=/\r\n");
        printWriter.print("Accept-Ranges: bytes\r\n");
        printWriter.print("Transfer-Encoding: chunked\r\n");
        printWriter.print("Content-Type: text/html\r\n");
        printWriter.print("\r\n");
        String string = "<html><head><title>test</head><body>hello world!</body></html>";
        int n2 = string.length();
        printWriter.printf("%x\r\n", n2);
        printWriter.print(string);
        printWriter.print("\r\n");
        printWriter.print("0\r\n\r\n");
        printWriter.close();
        try {
            socket.close();
            serverSocket.close();
        }
        catch (IOException iOException) {
            System.out.println("ERROR: Could not close sockets");
            System.exit(-1);
        }
    }
}
