import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        boolean connectedAndDone = false;  // Flag to determine when connection has successfully ended

        do { // Keep reconnecting if server/client closes unexpectedly
            try {
                socket = new Socket("localhost", 4448);
                is = socket.getInputStream(); // Get IO streams once connected to server
                os = socket.getOutputStream();
                dis = new DataInputStream(is);
                dos = new DataOutputStream(os);

                do {
                    /* Send data as per your logic here, example code below */
                    for (byte b : "Test message".getBytes()) {
                        dos.writeByte(b); // Send bytes until done
                    }
                    Thread.sleep(50); // Wait a bit before closing to give server time to process request
                    /* Send end flag so server knows we want to stop */
                    dos.writeByte((byte) -1); // Send close command

                    int read = dis.readInt(); // Wait for confirmation response from server indicating graceful shutdown
                    if (read == -1) {
                        System.out.println("SERVER CONFIRMED SHUTDOWN");
                        connectedAndDone = true;
                        break; // Break inner loop as server has confirmed shutdown
                    } else {
                        throw new Exception("Server did not close correctly! Received: " + read);
                    }
                } while (true && !connectedAndDone); // Keep trying until successful or user aborts

            } catch (IOException e) {
                connectedAndDone = false; // Set this flag to retry on connection error
                Thread.sleep(10); // Wait a bit before trying again
            } catch (InterruptedException e) {
                connectedAndDone = true; // Break loop once thread is interrupted/app quits
                Thread.currentThread().interrupt(); // Preserve interrupt status
            } catch (Exception e) {
                // Handle other exceptions if necessary
                e.printStackTrace();
            } finally {
                // Cleanup resources after use to ensure no leaks occur
                if (dos != null) {
                    try { dos.close(); } catch (IOException e) { /* Ignore on close */ }
                }
                if (dis != null) {
                    try { dis.close(); } catch (IOException e) { /* Ignore on close */ }
                }
                if (socket != null) {
                    try { socket.close(); } catch (IOException e) { /* Ignore on close */ }
                }
            }
        } while (!connectedAndDone && !Thread.currentThread().isInterrupted()); // Keep reconnecting until user aborts

        System.out.println("All done!"); // Finally block ends and we can tell the world about it ;)
    }
}