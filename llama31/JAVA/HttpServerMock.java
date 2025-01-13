import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerMock {
    public static void main(String[] args) {
        int snoopPort = 8080; // replace with your desired port

        ServerSocket client = null;
        try {
            client = new ServerSocket(snoopPort);
        } catch (IOException e) {
            System.out.println("ERROR: Could not listen on port: " + snoopPort);
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = client.accept();
        } catch (IOException e) {
            System.out.println("ERROR: Accept failed on port: " + snoopPort);
            System.exit(-1);
        }

        PrintWriter snoopOut = null;
        try {
            snoopOut = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("ERROR: Could not get output stream");
            System.exit(-1);
        }

        snoopOut.print("HTTP/1.1 200 OK\r\n");
        snoopOut.print("Date: Thu, 05 Feb 2009 06:37:28 GMT\r\n");
        snoopOut.print("Server: Apache\r\n");
        snoopOut.print("Set-Cookie: Apache=99.245.58.244.1233815848703045; path=/\r\n");
        snoopOut.print("Accept-Ranges: bytes\r\n");
        snoopOut.print("Transfer-Encoding: chunked\r\n");
        snoopOut.print("Content-Type: text/html\r\n");
        snoopOut.print("\r\n");

        String responseBody = "<html><head><title>test</head><body>hello world!</body></html>";
        int responseBodyLength = responseBody.length();

        snoopOut.printf("%x\r\n", responseBodyLength); // send chunk size
        snoopOut.print(responseBody); // send chunk data
        snoopOut.print("\r\n"); // send chunk terminator

        snoopOut.print("0\r\n\r\n"); // send final chunk (empty)

        snoopOut.close();

        try {
            clientSocket.close();
            client.close();
        } catch (IOException e) {
            System.out.println("ERROR: Could not close sockets");
            System.exit(-1);
        }
    }
}