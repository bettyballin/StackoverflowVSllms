import java.lang.String;
import java.io.PrintWriter;
import java.net.Socket;

public class HeartbeatSender {

    static final int PORT = PORT; // the application listening on the other end of this socket (default to any known open port)

    public static void main(String[] args) {

        String serverHostname = new String("SERVER_IP"); // your reliable remote host IP

        int port = PORT;

        while (true) {
            try {
                Socket aSocket = new Socket(serverHostname, port);
                PrintWriter out = new PrintWriter(aSocket.getOutputStream(), true); // write data down
                out.write("ALIVE\r\n"); // signal the server that this client is still alive and expecting an ACK.
            } catch (Exception e) {
                System.err.println("Caught exception: " + e);
                // log the error or send notification to yourself here. The connection failed or has been lost.
            }
        }

    }
}