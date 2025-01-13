import java.net.Socket;
import java.io.OutputStream;
import java.lang.Thread;

public class TcpClientLoop {
    public static void main(String[] args) {
        Socket s;
        try {
            s = new Socket("localhost", 4448);
            s.setKeepAlive(true);
            s.setReuseAddress(true);
            OutputStream os = s.getOutputStream();
            int counter = 0;
            while (true) {
                try {
                    os.write((byte) counter++);
                    os.flush();
                    Thread.sleep(1000); // wait 1 second before reconnecting
                    os.close();
                    s.close();
                    s = new Socket("localhost", 4448);
                    s.setKeepAlive(true);
                    s.setReuseAddress(true);
                    os = s.getOutputStream();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("ERROR: reconnecting...");
                    try {
                        Thread.sleep(5000); // wait 5 seconds before retrying
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt(); // Restore interrupted status
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR: could not connect");
        }
    }
}