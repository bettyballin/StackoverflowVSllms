/*
 * Decompiled with CFR 0.152.
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloService {
    public static String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] stringArray) throws Exception {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/hello", new HelloHandler());
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("Server running on port 8000");
    }

    static class HelloHandler
    implements HttpHandler {
        HelloHandler() {
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String string = HelloService.sayHello();
            httpExchange.sendResponseHeaders(200, string.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(string.getBytes());
            outputStream.close();
        }
    }
}
