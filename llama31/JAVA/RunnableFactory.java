import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RunnableFactory {
    // Avoid Class.newInstance, for it is evil.
    public static void main(String[] args) {
        try {
            Class<?> runClass = Class.forName("java.lang.Runnable");
            Class<?> clazz = Class.forName("java.lang.Thread"); // Use a concrete class that implements Runnable
            Constructor<?> ctor = clazz.getConstructor();
            Runnable doRun = (Runnable) ctor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            // Handle the exception explicitly
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}