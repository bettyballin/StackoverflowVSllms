import java.net.URL;
import java.net.URLClassLoader;

public class ReloadableClassLoader extends URLClassLoader {
    public ReloadableClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        if (shouldReload(name)) {
            return findClass(name);
        }
        return super.loadClass(name, resolve);
    }

    private boolean shouldReload(String className) {
        // Implement your logic here to decide whether the class should be reloaded.
        return className.contains("YourTargetClassName");
    }

    public static void main(String[] args) {
    }
}