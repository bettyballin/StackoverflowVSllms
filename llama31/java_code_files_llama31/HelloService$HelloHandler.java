/*
 * Decompiled with CFR 0.152.
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

static class HelloService.HelloHandler
implements HttpHandler {
    HelloService.HelloHandler() {
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
