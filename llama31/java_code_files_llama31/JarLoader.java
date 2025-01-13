/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.net.URLClassLoader;

public class JarLoader {
    public static void loadJar(String string) throws Exception {
        URL uRL = new URL("jar:file:" + string + "!/");
        URLClassLoader uRLClassLoader = new URLClassLoader(new URL[]{uRL});
        Class<?> clazz = uRLClassLoader.loadClass("com.example.MyClass");
        Object obj = clazz.newInstance();
    }

    public static void main(String[] stringArray) throws Exception {
        JarLoader.loadJar("/path/to/your/jarfile.jar");
    }
}
