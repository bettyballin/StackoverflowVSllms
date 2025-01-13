import java.lang.String;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;
import java.util.Random;

public class SSLOverheadEstimate {
    public static void main(String[] args) throws Exception {
        SSLContext sslContext = SSLContext.getDefault();
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        Socket socket = sslSocketFactory.createSocket("example.com", 443);

        // Generate a large random message
        byte[] message = new byte[1024 * 10];
        new Random().nextBytes(message);

        long startTime = System.nanoTime();
        // Send the message over the SSL/TLS connection
        socket.getOutputStream().write(message);
        socket.getOutputStream().flush();
        long endTime = System.nanoTime();

        // Estimate the encryption overhead
        long encryptionTime = endTime - startTime;
        double encryptionOverhead = (encryptionTime / (double) message.length) * 100;
        System.out.println("Estimated encryption overhead: " + encryptionOverhead + "%");
    }
}