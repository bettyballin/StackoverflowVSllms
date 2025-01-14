import javax.net.ssl.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.io.IOException;

public interface MyRemoteInterface {
    void myMethod();
}

public class MyRemoteImpl implements MyRemoteInterface {

    @Override
    public void myMethod() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            SSLServerSocket serverSocket = null;
            try {
                SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(443);
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            }

            if (serverSocket == null) return;

            try (SSLSocket sslSocket = (SSLSocket) serverSocket.accept()) {
                SSLSession sslSession = sslSocket.getSession();
                X509Certificate[] peerCertificates = (X509Certificate[]) sslSession.getPeerCertificates();
                Principal clientPrincipal = peerCertificates[0].getSubjectX500Principal();
                System.out.println("Client certificate subject: " + clientPrincipal.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }

    public static void main(String[] args) {
    }
}