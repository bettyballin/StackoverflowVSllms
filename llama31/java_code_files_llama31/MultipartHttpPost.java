/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultipartHttpPost {
    public static void main(String[] stringArray) throws IOException {
        int n;
        URL uRL = new URL("http://api.scribd.com/api");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=END_OF_FILE");
        String string = "END_OF_FILE";
        String string2 = "example.txt";
        File file = new File(string2);
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(("--" + string + "\r\n").getBytes());
        outputStream.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + string2 + "\"\r\n").getBytes());
        outputStream.write("Content-Type: text/plain\r\n\r\n".getBytes());
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] byArray = new byte[1024];
        while ((n = fileInputStream.read(byArray)) != -1) {
            outputStream.write(byArray, 0, n);
        }
        fileInputStream.close();
        outputStream.write(("\r\n--" + string + "--\r\n").getBytes());
        outputStream.close();
        int n2 = httpURLConnection.getResponseCode();
        System.out.println("Response Code: " + n2);
    }
}
