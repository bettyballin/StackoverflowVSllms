import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpSnoopServer {
    public static void main(String[] args) {
        int snoopPort = 8000; // Define the port

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

        // Remove 'Transfer-Encoding: chunked' header
        snoopOut.print("HTTP/1.1 200 OK\r\n");
        snoopOut.print("Date: Thu, 05 Feb 2009 06:37:28 GMT\r\n");
        snoopOut.print("Server: Apache\r\n");
        snoopOut.print("Set-Cookie: Apache=99.245.58.244.1233815848703045; path=/\r\n");
        snoopOut.print("Accept-Ranges: bytes\r\n");
        snoopOut.print("Content-Type: text/html\r\n");
        snoopOut.print("Content-Length: 70\r\n"); // Add Content-Length
        snoopOut.print("\r\n");
        snoopOut.print("<html><head><title>test</title></head><body>hello world!</body></html>");

        snoopOut.close();

        try {
            clientSocket.close();
            client.close();
        } catch (IOException e) {
            System.out.println("ERROR: Could not close socket");
            System.exit(-1);
        }
    }
}