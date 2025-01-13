import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoaderExample_1_1 {
    public static void main(String[] args) throws Exception {
        // URLClassLoader example
        URL[] urls = {new URL("file:///path/to/jar/file.jar")};
        URLClassLoader newClassLoader = new URLClassLoader(urls);
        Class<?> mainClass = newClassLoader.loadClass("Main");
        Method mainMethod = mainClass.getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[]{});
    }
}