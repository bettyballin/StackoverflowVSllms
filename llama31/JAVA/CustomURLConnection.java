import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLConnection;

public class CustomURLConnection extends URLConnection {
    private Socket socket;

    public CustomURLConnection(Socket socket) {
        super(null); // URLConnection requires a URL in its constructor, but we don't need it in this case
        this.socket = socket;
    }

    @Override
    public void connect() throws IOException {
        // Handle the connection to your server socket
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // Return an input stream that reads from your server socket
        return socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        // Return an output stream that writes to your server socket
        return socket.getOutputStream();
    }

    public static void main(String[] args) {
    }
}