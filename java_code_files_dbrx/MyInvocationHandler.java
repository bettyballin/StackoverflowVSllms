import java.lang.reflect.*;
import java.util.*;

public class MyInvocationHandler implements InvocationHandler {
    private Set<Method> annMethods;

    public MyInvocationHandler() {
        annMethods = new HashSet<Method>();
        // Let's suppose we have an interface with methods annotated with @Column
        try {
            Method annotatedMethod = MyInterface.class.getMethod("annotatedMethod");
            annMethods.add(annotatedMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (annMethods.contains(method)) { // Use this line to check if current invoked is one of your @Column-annotated methods.
            // Handle @Column-annotated method
            System.out.println("Invoked an @Column-annotated method: " + method.getName());
            // Implement the functionality for the annotated methods here
            return null; // or appropriate return value
        }
        // Handle other methods
        System.out.println("Invoked a non-annotated method: " + method.getName());
        return null; // or appropriate return value
    }

    public static void main(String[] args) {
        // Create a proxy instance
        MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
            MyInterface.class.getClassLoader(),
            new Class[] { MyInterface.class },
            new MyInvocationHandler()
        );

        // Invoke methods to test
        proxyInstance.annotatedMethod();
        proxyInstance.nonAnnotatedMethod();
    }
}

// Sample interface
interface MyInterface {
    void annotatedMethod();
    void nonAnnotatedMethod();
}