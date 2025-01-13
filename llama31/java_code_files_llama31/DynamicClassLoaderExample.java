/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoaderExample {
    public static void main(String[] stringArray) throws Exception {
        URLClassLoader uRLClassLoader = new URLClassLoader(new URL[]{new File(System.getProperty("java.io.tmpdir")).toURI().toURL()});
        Class<?> clazz = uRLClassLoader.loadClass("MyClass");
        Class<?> clazz2 = uRLClassLoader.loadClass("MyAnotherClass");
    }
}
