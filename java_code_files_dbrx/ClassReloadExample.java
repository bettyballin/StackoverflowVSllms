import java.lang.String;
import java.net.URLClassLoader;
import java.net.URL;
import java.net.MalformedURLException;

public class ClassReloadExample {
    public static void reload(String className) throws Exception {
        // Create new class loader instance
        URLClassLoader cl = new MyClassLoader();

        // Load the new version of the class using custom loader
        Class<?> c = cl.loadClass(className);

        // Call some method in loaded type, e.g., default constructor for simplicity here:
        Object o = c.getDeclaredConstructor().newInstance();
    }

    public static void main(String[] args) {
        // You can test the reload method here if needed
    }
}

class MyClassLoader extends URLClassLoader {
    public MyClassLoader() throws MalformedURLException {
        super(new URL[]{ new URL("file:./") });
    }
}