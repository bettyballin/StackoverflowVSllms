import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class ClassLoaderModifier {
    URL customUrlHere;

    public ClassLoaderModifier() throws Exception {
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class<?> urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[] { URL.class });
        method.setAccessible(true);
        method.invoke(urlClassLoader, new Object[] { customUrlHere });
    }

    public static void main(String[] args) {
    }
}