/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.net.URLClassLoader;

public class PreloadingClassLoader
extends URLClassLoader {
    public PreloadingClassLoader(URL[] uRLArray, ClassLoader classLoader) {
        super(uRLArray, classLoader);
        this.preloadClasses();
    }

    private void preloadClasses() {
        try {
            this.loadClass("com.example.MyClass1");
            this.loadClass("com.example.MyClass2");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Error preloading classes: " + classNotFoundException.getMessage());
        }
    }

    public static void main(String[] stringArray) {
        URL[] uRLArray = new URL[]{};
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        PreloadingClassLoader preloadingClassLoader = new PreloadingClassLoader(uRLArray, classLoader);
    }
}
