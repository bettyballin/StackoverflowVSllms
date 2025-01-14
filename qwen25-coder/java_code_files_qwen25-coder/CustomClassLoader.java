import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader {
    URLClassLoader child = new URLClassLoader(
           new URL[] { } /* URLs for your dependencies */,
           Thread.currentThread().getContextClassLoader()
       );

    public static void main(String[] args) {
    }
}