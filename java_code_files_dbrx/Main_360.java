import java.lang.String;
import java.lang.Integer;
import java.lang.reflect.*;

public class Main_360 {
    public static void main(String[] args) throws Exception {
        // Class name (fully qualified), method name, and parameter types
        String className = "yourpackage.YourClass";
        String funcName = "yourMethod";
        Object[] parameters = {"parameter1", 2}; // Parameters for the function
        Class<?>[] paramTypes = new Class[] {String.class, Integer.class}; // Parameter types

        // Get a reference to the class and instantiate it
        Class cls = Class.forName(className);
        Object object = cls.getConstructor().newInstance();

        // Call your function dynamically with parameters using Reflection API
        Method method = cls.getMethod(funcName, paramTypes);
        Object result = method.invoke(object, parameters);
    }
}