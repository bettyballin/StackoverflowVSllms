import java.net.Socket;
import java.net.SocketTimeoutException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.IOException;

public class Main_280 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.google.com", 80);
            PrintStream sender = new PrintStream(s.getOutputStream());
            InputStream receiver = s.getInputStream();

            // Set a timeout of 5 seconds
            s.setSoTimeout(5000);

            sender.print("GET / HTTP/1.0\r\n\r\n");
            sender.flush();
            s.shutdownOutput();

            StringBuilder response = new StringBuilder();
            boolean eof = false;

            while (!eof) {
                try {
                    int i = receiver.read();
                    if (i == -1) {
                        eof = true;
                    } else {
                        response.append((char) i);
                    }
                } catch (SocketTimeoutException e) {
                    // Connection timed out, assume it's closed
                    eof = true;
                }
            }

            System.out.println(response.toString());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}