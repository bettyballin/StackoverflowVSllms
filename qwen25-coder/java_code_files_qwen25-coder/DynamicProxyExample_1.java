import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Define some sample interfaces
interface InterfaceA {
    void methodA();
}

interface InterfaceB {
    int methodB(String param);
}

public class DynamicProxyExample_1 {

    public static void main(String[] args) {
        // Create a dynamic proxy that implements InterfaceA and InterfaceB
        Object proxy = Proxy.newProxyInstance(
            DynamicProxyExample_1.class.getClassLoader(),
            new Class<?>[]{InterfaceA.class, InterfaceB.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // Custom handling logic
                    System.out.println("Method called: " + method.getName());
                    if (args != null) {
                        for (Object arg : args) {
                            System.out.println("\tArgument: " + arg);
                        }
                    }
                    // Return a default value or throw an exception based on the return type of method
                    if (method.getReturnType() == int.class) {
                        return 42; // For integer methods
                    } else if (method.getReturnType() == void.class) {
                        return null; // For void methods
                    } else {
                        throw new UnsupportedOperationException("Unsupported method");
                    }
                }
            });

        // Cast the proxy to InterfaceA and call its method
        InterfaceA interfaceA = (InterfaceA) proxy;
        interfaceA.methodA();

        // Cast the proxy to InterfaceB and call its method
        InterfaceB interfaceB = (InterfaceB) proxy;
        int result = interfaceB.methodB("example");
        System.out.println("Result of methodB: " + result);
    }
}