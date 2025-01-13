import java.lang.String;
import java.lang.reflect.Method;

public class DynamicMethodInvoker {
    public static void main(String[] args) throws Exception {
        // Class name
        String className = "MyClass";

        // Method name
        String methodName = "myMethod";

        // Parameters
        Object[] params = new Object[] {"Hello", 123};

        // Get the class instance
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.newInstance();

        // Get the method
        Method method = clazz.getMethod(methodName, String.class, int.class);

        // Invoke the method
        method.invoke(instance, params);
    }
}

class MyClass {
    public void myMethod(String param1, int param2) {
        System.out.println("myMethod called with params: " + param1 + ", " + param2);
    }
}