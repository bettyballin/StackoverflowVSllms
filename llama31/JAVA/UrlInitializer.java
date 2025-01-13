import java.lang.String;
import java.net.URL;

public class UrlInitializer {
    static {
        URL.setURLStreamHandlerFactory(new CustomURLStreamHandlerFactory());
    }

    public static void main(String[] args) {
    }
}