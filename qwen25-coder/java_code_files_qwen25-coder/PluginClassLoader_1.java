import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader_1 {
    public static void main(String[] args) throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[] {new File("/path/to/plugin.jar").toURI().toURL()});
        Class<?> loadedClass = classLoader.loadClass("com.example.Plugin");
    }
}