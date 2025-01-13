import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Main_76 {
    public static void main(String[] args) throws Exception {
        // Create an SSLContext
        SSLContext sslContext = SSLContext.getDefault();

        // Create an SSLSocketFactory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create an SSLSocket
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("smtp.gmail.com", 465);

        // Enable TLS Session Resumption
        sslSocket.setEnabledProtocols(new String[] {"TLSv1.2"});
        sslSocket.setUseSessionTickets(true);

        // Perform the initial TLS handshake
        sslSocket.startHandshake();

        // Store the session state for resumption
        byte[] sessionID = sslSocket.getSession().getId();

        // Later, resume the TLS session
        sslSocket = (SSLSocket) sslSocketFactory.createSocket("smtp.gmail.com", 465);
        sslSocket.setUseSessionTickets(true);
        // Note: The original code had a call to sslSocket.resumeHandshake(sessionID);
        // However, there is no such method as resumeHandshake() in SSLSocket.
        // Instead, we can use the startHandshake() method again, 
        // and the session will be resumed if the ID matches.
        sslSocket.startHandshake();
    }
}