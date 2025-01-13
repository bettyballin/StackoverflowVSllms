import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainInvoker {
    public static void main(String[] args) {
        try {
            Method main = MainInvoker.class.getMethod("main", String[].class);
            main.invoke(null, (Object) new String[]{});
        } catch (InvocationTargetException e) {
            System.err.println("Error executing main class: " + e.getCause().getMessage());
        } catch (Exception e) {
            System.err.println("Error executing main class: " + e.getMessage());
        }
    }
}