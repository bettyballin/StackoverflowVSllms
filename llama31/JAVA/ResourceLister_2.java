import java.lang.String;
import java.net.URL;
import org.apache.commons.lang3.ClassLoaderUtils;

public class ResourceLister_2_2 {
    public static void listResources(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL[] resources = ClassLoaderUtils.getResources(classLoader, packageName);
        for (URL resource : resources) {
            System.out.println(resource);
        }
    }

    public static void main(String[] args) {
        listResources("com.example.mypackage");
    }
}