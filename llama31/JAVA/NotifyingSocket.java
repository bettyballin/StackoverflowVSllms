import java.io.IOException;
import java.net.Socket;

public class NotifyingSocket extends Socket {
    @Override
    public int receive(byte[] data) throws IOException {
        notifyController(); // notify the controller here
        return super.getInputStream().read(data);
    }

    private void notifyController() {
        // Implement notification logic here
        System.out.println("Notifying controller...");
    }

    public static void main(String[] args) {
        try {
            NotifyingSocket socket = new NotifyingSocket();
            byte[] data = new byte[1024];
            socket.receive(data);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}