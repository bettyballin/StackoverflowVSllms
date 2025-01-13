/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class Main_239 {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getDefault();
        SSLServerSocketFactory sSLServerSocketFactory = sSLContext.getServerSocketFactory();
        try {
            SSLServerSocket sSLServerSocket = (SSLServerSocket)sSLServerSocketFactory.createServerSocket(443);
        }
        catch (Exception exception) {
            System.out.println("Error creating SSLServerSocket: " + exception.getMessage());
        }
    }
}
