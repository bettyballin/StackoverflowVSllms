import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class ContextClassLoaderExample {
    public static void main(String[] args) {
        // Create a different ClassLoader for each thread
        URLClassLoader child = new URLClassLoader(new URL[0], null);

        try {
            Thread.currentThread().setContextClassLoader(child);

            Runnable r = (Runnable) child.loadClass("your.package.MyThread").newInstance();

            // Run it in a separate thread
            new Thread(r).start();
        } catch(Exception e) {
            throw new AssertionError(e);
        }
    }
}