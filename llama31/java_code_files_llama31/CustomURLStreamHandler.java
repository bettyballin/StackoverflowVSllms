/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class CustomURLStreamHandler
extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL uRL) throws IOException {
        Socket socket = new Socket("myhost.tld", 8080);
        return new CustomURLConnection(socket);
    }

    public static void main(String[] stringArray) {
    }
}
