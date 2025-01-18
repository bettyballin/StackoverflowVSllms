import java.lang.String;
import java.net.ServerSocket;
import java.io.IOException;

public class ShutdownHookManager {

    private static ServerSocket serverSocket;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                serverSocket.close(); //Replace with your actual socket object.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "Shutdown Hook"));
    }

    public static void main(String[] args) {
    }
}