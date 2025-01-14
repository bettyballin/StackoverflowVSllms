import java.lang.String;
public class NetworkCommunication {
    public static void main(String[] args) {
        // Example of sending a message using higher-level protocol (e.g., HTTP)
        String message = "Hello, world!";
        sendMessage(message);
    }

    private static void sendMessage(String message) {
        // Simulate sending a message over the network
        System.out.println("Sending message: " + message);
    }
}