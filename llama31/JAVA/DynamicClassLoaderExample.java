import java.io.File;
import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoaderExample {
    public static void main(String[] args) throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[] { new File(System.getProperty("java.io.tmpdir")).toURI().toURL() });

        // Load a class
        Class<?> clazz = classLoader.loadClass("MyClass");

        // Load another class
        Class<?> anotherClazz = classLoader.loadClass("MyAnotherClass");
    }
}