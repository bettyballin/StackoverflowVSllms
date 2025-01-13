import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class FileServerResponseHandler implements HttpHandler {

    private HttpExchange httpExchange;
    private File requestedFile;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        this.httpExchange = httpExchange;
        // assuming requestedFile is already set
        this.getHttpExchange().getResponseHeaders().set("Content-Length", String.valueOf(requestedFile.length()));
    }

    public HttpExchange getHttpExchange() {
        return httpExchange;
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8000), 0);
        server.createContext("/test", new FileServerResponseHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}