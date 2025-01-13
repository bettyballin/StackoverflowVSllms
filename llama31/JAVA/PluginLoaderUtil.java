import java.lang.String;
import java.net.URL;
import java.net.MalformedURLException;

public class PluginLoaderUtil {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        SecurePluginClassLoader loader = new SecurePluginClassLoader(new URL[] { new URL("file:///path/to/plugin.jar") });
        Class<?> clazz = loader.loadClass("com.example.Plugin");
    }
}

class SecurePluginClassLoader extends URLClassLoader {
    public SecurePluginClassLoader(URL[] urls) {
        super(urls);
    }
}