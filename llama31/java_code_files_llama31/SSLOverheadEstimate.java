/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;
import java.util.Random;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SSLOverheadEstimate {
    public static void main(String[] stringArray) throws Exception {
        SSLContext sSLContext = SSLContext.getDefault();
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        Socket socket = sSLSocketFactory.createSocket("example.com", 443);
        byte[] byArray = new byte[10240];
        new Random().nextBytes(byArray);
        long l = System.nanoTime();
        socket.getOutputStream().write(byArray);
        socket.getOutputStream().flush();
        long l2 = System.nanoTime();
        long l3 = l2 - l;
        double d = (double)l3 / (double)byArray.length * 100.0;
        System.out.println("Estimated encryption overhead: " + d + "%");
    }
}
