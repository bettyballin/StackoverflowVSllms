import java.lang.String;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ResourceLister {
    public static void listResources(String packageName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(packagePath);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            System.out.println(resource);
        }
    }

    public static void main(String[] args) throws IOException {
        listResources("com.example.mypackage");
    }
}