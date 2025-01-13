/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;

public class ClassLoaderUtil {
    public static void main(String[] stringArray) {
        try {
            Thread.currentThread().setContextClassLoader(new PreloadingClassLoader(new URL[0], ClassLoader.getSystemClassLoader()));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
