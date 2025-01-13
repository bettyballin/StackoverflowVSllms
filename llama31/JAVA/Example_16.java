import java.net.SocketException;
import java.io.IOException;
import java.lang.Runtime;

public class Example_16_16 {
    public static void main(String[] args) {
        try {
            // Code that attempts to use a port
            // For demonstration purposes, let's try to create a socket on a port
            java.net.Socket socket = new java.net.Socket("localhost", 8080);
        } catch (SocketException e) {
            System.out.println("java.net.SocketException: Permission denied: connect");
            // Use netstat command to find the process using the port
            try {
                Process netstatProcess = Runtime.getRuntime().exec("netstat -ano | findstr 8080");
                java.util.Scanner s = new java.util.Scanner(netstatProcess.getInputStream());
                String line = s.nextLine();
                String[] parts = line.split("\\s+");
                String pid = parts[parts.length - 1];
                // Use taskkill command with /PID and /F flags to kill the process
                Process taskkillProcess = Runtime.getRuntime().exec("taskkill /PID " + pid + " /F");
                System.out.println("Killed process with PID: " + pid);
            } catch (IOException ex) {
                System.out.println("Error executing command: " + ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error creating socket: " + e.getMessage());
        }
    }
}