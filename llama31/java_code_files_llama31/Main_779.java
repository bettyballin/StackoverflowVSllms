/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main_779 {
    public static void main(String[] stringArray) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        try {
            while (true) {
                OutputStream outputStream = socket.getOutputStream();
                String string = "ping";
                outputStream.write(string.getBytes(StandardCharsets.UTF_8));
                Thread.sleep(1000L);
            }
        }
        catch (IOException | InterruptedException exception) {
            System.out.println("Error sending ping: " + exception.getMessage());
            return;
        }
    }
}
