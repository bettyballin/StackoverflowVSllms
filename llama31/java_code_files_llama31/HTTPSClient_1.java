/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HTTPSClient_1 {
    public static void main(String[] stringArray) throws Exception {
        String string;
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket("example.com", 443);
        sSLSocket.startHandshake();
        PrintWriter printWriter = new PrintWriter(sSLSocket.getOutputStream(), true);
        printWriter.println("GET / HTTP/1.1");
        printWriter.println("Host: example.com");
        printWriter.println();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sSLSocket.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        sSLSocket.close();
    }
}
