import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import javax.net.ssl.HttpsURLConnection;

public class CustomURLStreamHandlerFactory implements URLStreamHandlerFactory {
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if ("https".equals(protocol)) {
            return new CustomHttpsHandler();
        }
        return null;
    }

    private static class CustomHttpsHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new HttpsURLConnection(url);
        }
    }

    public static void main(String[] args) {
        // Set the URLStreamHandlerFactory for the application
        URL.setURLStreamHandlerFactory(new CustomURLStreamHandlerFactory());
    }
}