/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.net.URLConnection;

public class DataReceiver {
    public static void main(String[] stringArray) throws Exception {
        int n;
        URLConnection uRLConnection = null;
        InputStream inputStream = uRLConnection.getInputStream();
        byte[] byArray = new byte[1024];
        while ((n = inputStream.read(byArray)) != -1) {
            DataReceiver.processReceivedData(byArray, n);
        }
    }

    private static void processReceivedData(byte[] byArray, int n) {
        System.out.println("Received " + n + " bytes");
    }
}
