import java.lang.String;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderExplorer {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        while (classLoader != null) {
            if (classLoader instanceof URLClassLoader) {
                URL[] urls = ((URLClassLoader) classLoader).getURLs();
                for (URL url : urls) {
                    System.out.println("Loaded from: " + url);
                    // Print the classes loaded from this URL
                    printLoadedClasses(classLoader, url);
                }
            }
            classLoader = classLoader.getParent();
        }
    }

    private static void printLoadedClasses(ClassLoader classLoader, URL url) {
        try {
            Method method = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
            method.setAccessible(true);
            String[] classNames = getclassNames(url);
            for (String className : classNames) {
                Class<?> clazz = (Class<?>) method.invoke(classLoader, className);
                if (clazz != null) {
                    System.out.println("  " + clazz.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] getclassNames(URL url) {
        // Implement a way to get the class names from the URL (e.g., by parsing the JAR file)
        // For demonstration purposes, assume we have a JAR file with two classes: Foo.class and Bar.class
        return new String[] {"Foo", "Bar"};
    }
}