import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RunnableFactory_1_1 {
    public static void main(String[] args) {
        try {
            Class<?> runClass = Class.forName("java.lang.Runnable");
            Constructor<?> constructor = runClass.getConstructor();
            Object doRun = constructor.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("No such method: " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Instantiation exception: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access exception: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("Invocation target exception: " + e.getMessage());
        }
    }
}