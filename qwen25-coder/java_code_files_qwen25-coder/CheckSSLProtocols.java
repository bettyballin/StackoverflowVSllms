import java.lang.String;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class CheckSSLProtocols {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory sslsockfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) sslsockfact.createSocket((java.net.Socket) null, null, -1, false);

        String[] supportedProtocols = socket.getSupportedProtocols();
        System.out.println("Supported Protocols: ");
        for (String protocol : supportedProtocols) {
            System.out.println("\t" + protocol);
        }

        String enabledProtocols[] = socket.getEnabledProtocols();
        System.out.println("Enabled Protocols:");
        for (String protocol : enabledProtocols) {
            System.out.println("\t" + protocol);
        }
    }
}