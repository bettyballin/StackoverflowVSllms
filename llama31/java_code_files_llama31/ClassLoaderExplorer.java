/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderExplorer {
    public static void main(String[] stringArray) {
        for (ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); classLoader != null; classLoader = classLoader.getParent()) {
            URL[] uRLArray;
            if (!(classLoader instanceof URLClassLoader)) continue;
            for (URL uRL : uRLArray = ((URLClassLoader)classLoader).getURLs()) {
                System.out.println("Loaded from: " + String.valueOf(uRL));
                ClassLoaderExplorer.printLoadedClasses(classLoader, uRL);
            }
        }
    }

    private static void printLoadedClasses(ClassLoader classLoader, URL uRL) {
        try {
            String[] stringArray;
            Method method = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
            method.setAccessible(true);
            for (String string : stringArray = ClassLoaderExplorer.getclassNames(uRL)) {
                Class clazz = (Class)method.invoke((Object)classLoader, string);
                if (clazz == null) continue;
                System.out.println("  " + clazz.getName());
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static String[] getclassNames(URL uRL) {
        return new String[]{"Foo", "Bar"};
    }
}
