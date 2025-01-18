import java.lang.String;
import java.lang.reflect.*;

public class ClassforNameandReflectionUtil {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.example.MyObject");
        Constructor<?> cons = clazz.getDeclaredConstructor(String.class, int.class); // Get constructor that takes a String and an int as arguments
        cons.setAccessible(true);  // Make constructor accessible (if private)
        Object obj = cons.newInstance("Hello", 42);
    }
}