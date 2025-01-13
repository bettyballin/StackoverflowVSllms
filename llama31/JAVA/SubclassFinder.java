import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SubclassFinder {
    public static List<Class<?>> getSubclasses(Class<?> clazz) {
        List<Class<?>> subclasses = new ArrayList<>();

        try {
            // Get all classes loaded by the current class loader
            Class<?> classLoaderClass = Class.forName("java.lang.ClassLoader");
            Method getAllLoadedClassesMethod = classLoaderClass.getDeclaredMethod("getAllLoadedClasses");
            getAllLoadedClassesMethod.setAccessible(true);
            Class<?>[] classes = (Class<?>[]) getAllLoadedClassesMethod.invoke(clazz.getClassLoader());

            for (Class<?> c : classes) {
                if (clazz.isAssignableFrom(c) && !clazz.equals(c)) {
                    subclasses.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subclasses;
    }

    public static void main(String[] args) {
    }
}