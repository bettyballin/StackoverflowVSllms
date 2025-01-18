import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);  // Replace with your desired port
            Socket clientSocket = serverSocket.accept();

            PrintWriter snoopOut = new PrintWriter(clientSocket.getOutputStream(), true);
            snoopOut.print("HTTP/1.1 200 OK\r\n");
            snoopOut.print("Content-Type: text/html; charset=UTF-8\r\n");
            snoopOut.print("\r\n"); // blank line before the body message starts
            snoopOut.print("<!DOCTYPE html>\n<html><head><title>Test Page</title></head><body>hello world!</body></html>");

            snoopOut.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}