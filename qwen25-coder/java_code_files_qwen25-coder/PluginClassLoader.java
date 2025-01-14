import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {
    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    public Class<?> loadPluginClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    public static void main(String[] args) {
    }
}