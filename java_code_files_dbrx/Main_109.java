import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        // Your floating point value stored here
        double ret_val = 1234567890.123;

        Socket socket = null;
        DataOutputStream out = null;
        try {
            // Initialize the socket (e.g., connect to localhost on port 12345)
            socket = new Socket("localhost", 12345);

            out = new DataOutputStream(socket.getOutputStream());
            // Writing the double as 8 bytes in Big Endian Order
            out.writeDouble(ret_val);

        } catch (IOException e) {
            System.err.println("Error during socket communication");
            e.printStackTrace();
        } finally {
            // Close the DataOutputStream if it's open
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.err.println("Error closing DataOutputStream");
                    e.printStackTrace();
                }
            }
            // Close the socket if it's open
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket");
                    e.printStackTrace();
                }
            }
        }
    }
}