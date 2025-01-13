import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader {
    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[]{new URL("file:user_module.jar")};
        URLClassLoader loader = URLClassLoader.newInstance(urls);
        Class<?> userClass = loader.loadClass("UserModule");
        Method userMethod = userClass.getMethod("userFunction");
        userMethod.invoke(null); // invoke the user-provided method
    }
}