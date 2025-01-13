/*
 * Decompiled with CFR 0.152.
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleRestServer {
    public static void main(String[] stringArray) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/users", new UserHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }

    static class UserHandler
    implements HttpHandler {
        UserHandler() {
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String string = httpExchange.getRequestMethod();
            if (string.equals("GET")) {
                this.handleGet(httpExchange);
            } else if (string.equals("POST")) {
                this.handlePost(httpExchange);
            } else if (string.equals("PUT")) {
                this.handlePut(httpExchange);
            } else if (string.equals("DELETE")) {
                this.handleDelete(httpExchange);
            } else {
                httpExchange.sendResponseHeaders(405, -1L);
            }
        }

        private void handleGet(HttpExchange httpExchange) throws IOException {
            String string = "Hello, World!";
            httpExchange.sendResponseHeaders(200, string.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(string.getBytes());
            outputStream.close();
        }

        private void handlePost(HttpExchange httpExchange) throws IOException {
        }

        private void handlePut(HttpExchange httpExchange) throws IOException {
        }

        private void handleDelete(HttpExchange httpExchange) throws IOException {
        }
    }
}
