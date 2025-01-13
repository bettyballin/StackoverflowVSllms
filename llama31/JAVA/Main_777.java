import java.net.Socket;

public class Main_777 {
    public static void main(String[] args) {
        Socket socket = null; // Initialize socket, replace null with your actual socket initialization code
        if (socket != null && !socket.isClosed()) { // Note the ! operator
            // Possible remote side socket close detected
            System.out.println("Possible remote side socket close detected");
        }
    }
}