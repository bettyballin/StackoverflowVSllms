import java.lang.String;
import java.net.SocketException;
import java.io.IOException;
import java.net.ServerSocket;

public class Example_15_15 {
    public static void main(String[] args) {
        try {
            // Code that attempts to use a port
            ServerSocket serverSocket = new ServerSocket(8080); // Replace 8080 with the desired port
            serverSocket.close();
        } catch (SocketException e) {
            System.out.println("java.net.SocketException: Permission denied: connect");
            // Use netstat command to find the process using the port
            // Use taskkill command with /PID and /F flags to kill the process
            Runtime.getRuntime().exec("netstat -ano | findstr 8080"); // Replace 8080 with the desired port
            // Note: You need to manually identify the PID from the output and replace <PID> below
            Runtime.getRuntime().exec("taskkill /PID <PID> /F");
        } catch (IOException e) {
            System.out.println("An I/O error occurred");
        }
    }
}