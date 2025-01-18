import java.lang.String;
public class SSLServerSocketFactory {

    javax.net.ssl.SSLServerSocketFactory ssf = javax.net.ssl.SSLServerSocketFactory.getDefault();
    javax.net.ssl.SSLServerSocket serverSocket = (javax.net.ssl.SSLServerSocket) ssf.createServerSocket(443); // use 8080 or any free port

    // Optional if you want some control over the cipher suites used by your serversocket: https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html (Section 9)

    public static void main(String[] args) {
    }
}