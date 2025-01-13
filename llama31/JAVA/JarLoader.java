import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class JarLoader {
    public static void loadJar(String jarFilePath) throws Exception {
        URL url = new URL("jar:file:" + jarFilePath + "!/");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        // Load the class from the JAR file
        Class<?> clazz = classLoader.loadClass("com.example.MyClass");
        // Use the loaded class
        Object instance = clazz.newInstance();
    }

    public static void main(String[] args) throws Exception {
        loadJar("/path/to/your/jarfile.jar");
    }
}