/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlDownloader {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("my-url-string");
        URLConnection uRLConnection = uRL.openConnection();
        uRLConnection.connect();
        InputStream inputStream = uRLConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("output_file");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] byArray = new byte[256];
        int n = -1;
        while ((n = inputStream.read(byArray)) > -1) {
            bufferedOutputStream.write(byArray, 0, n);
        }
        inputStream.close();
        bufferedOutputStream.close();
    }
}
