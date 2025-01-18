import java.net.Socket;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLContext;

public class SSLExample {
    public static void main(String[] args) {
        try {
            SSLEngine sslEngine = SSLContext.getDefault().createSSLEngine();
            sslEngine.setUseClientMode(false); // server side

            Socket socket = new Socket("localhost", 4321);
            socket.getOutputStream().write("<message data>".getBytes());
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}