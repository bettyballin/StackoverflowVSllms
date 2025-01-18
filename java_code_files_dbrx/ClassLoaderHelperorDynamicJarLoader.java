import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class ClassLoaderHelperorDynamicJarLoader {
    public static void main(String[] args) throws Exception {
        File file = new File("/path/to/your.jar"); // replace with your path
        URL url = file.toURI().toURL();
        URLClassLoader cl = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(cl, url);
    }
}