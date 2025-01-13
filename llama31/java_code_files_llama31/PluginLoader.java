/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader {
    public static void main(String[] stringArray) throws Exception {
        URL[] uRLArray = new URL[]{new URL("file:user_module.jar")};
        URLClassLoader uRLClassLoader = URLClassLoader.newInstance(uRLArray);
        Class<?> clazz = uRLClassLoader.loadClass("UserModule");
        Method method = clazz.getMethod("userFunction", new Class[0]);
        method.invoke(null, new Object[0]);
    }
}
