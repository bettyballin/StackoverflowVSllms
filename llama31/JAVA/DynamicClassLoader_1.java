import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader_1_1 {
    URLClassLoader classLoader;

    public DynamicClassLoader_1() throws Exception {
        classLoader = new URLClassLoader(new URL[] { new File("/path/to/classes").toURI().toURL() });
    }

    public static void main(String[] args) throws Exception {
        new DynamicClassLoader_1();
    }
}