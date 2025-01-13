/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class RateLimitedSocketReader {
    public static void main(String[] stringArray) {
        try {
            int n;
            RateLimiter rateLimiter = new RateLimiter(0x100000, 1024, new Socket("example.com", 80).getInputStream());
            byte[] byArray = new byte[1024];
            while ((n = rateLimiter.read(byArray)) != -1) {
            }
        }
        catch (UnknownHostException unknownHostException) {
            System.err.println("Unknown host: " + unknownHostException.getMessage());
        }
        catch (IOException iOException) {
            System.err.println("I/O error: " + iOException.getMessage());
        }
    }
}
