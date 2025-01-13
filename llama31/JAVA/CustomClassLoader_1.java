import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader_1_1 {
    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[] { new URL("path/to/your/jarfile.jar") };
        URLClassLoader cl = new URLClassLoader(urls);
        Class<?> clazz = cl.loadClass("YourMainClass");
        // Use the class...
        cl.close();
    }
}