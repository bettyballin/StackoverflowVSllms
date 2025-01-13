/*
 * Decompiled with CFR 0.152.
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

public class FileServerResponseHandler
implements HttpHandler {
    private HttpExchange httpExchange;
    private File requestedFile;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        this.httpExchange = httpExchange;
        this.getHttpExchange().getResponseHeaders().set("Content-Length", String.valueOf(this.requestedFile.length()));
    }

    public HttpExchange getHttpExchange() {
        return this.httpExchange;
    }

    public static void main(String[] stringArray) throws Exception {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/test", new FileServerResponseHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }
}
