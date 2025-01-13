import java.io.File;
import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader_2_2 {
    URLClassLoader classLoader = new URLClassLoader(new URL[] { new File(System.getProperty("java.io.tmpdir")).toURI().toURL() }, Thread.currentThread().getContextClassLoader());

    public static void main(String[] args) {
    }
}