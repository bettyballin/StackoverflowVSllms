/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ResourceLister {
    public static void listResources(String string) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String string2 = string.replace('.', '/');
        Enumeration<URL> enumeration = classLoader.getResources(string2);
        while (enumeration.hasMoreElements()) {
            URL uRL = enumeration.nextElement();
            System.out.println(uRL);
        }
    }

    public static void main(String[] stringArray) throws IOException {
        ResourceLister.listResources("com.example.mypackage");
    }
}
