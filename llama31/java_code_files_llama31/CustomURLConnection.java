/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.Socket;
import java.net.URLConnection;

class CustomURLConnection
extends URLConnection {
    private Socket socket;

    public CustomURLConnection(Socket socket) {
        super(null);
        this.socket = socket;
    }

    @Override
    public void connect() throws IOException {
    }
}
