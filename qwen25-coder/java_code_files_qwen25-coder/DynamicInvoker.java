import java.lang.String;
import java.lang.reflect.Method;

public class DynamicInvoker {

    public static void main(String[] args) {
        try {
            // Create an instance of the class containing the method
            MyClass myClassInstance = new MyClass();

            // Method name to be invoked dynamically
            String methodName = "myMethod";

            // Parameters for the method if any
            Class<?>[] parameterTypes = {String.class, int.class};
            Object[] parameters = {"Hello", 123};

            // Invoke the method using reflection
            Method method = myClassInstance.getClass().getMethod(methodName, parameterTypes);
            method.invoke(myClassInstance, parameters);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyClass {

    public void myMethod(String message, int number) {
        System.out.println("Message: " + message + ", Number: " + number);
    }
}