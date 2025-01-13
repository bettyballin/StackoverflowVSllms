import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Handle the method invocation here
        System.out.println("Method invoked: " + method.getName());
        return null; // or return a value, depending on your needs
    }

    public static void main(String[] args) {
        // Create a dynamic proxy that implements multiple interfaces
        Class<?>[] interfaces = new Class<?>[]{Interface1.class, Interface2.class};
        Object proxy = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), interfaces, new DynamicProxy());

        // Use the proxy as if it were an instance of the interfaces
        Interface1 i1 = (Interface1) proxy;
        i1.method1();

        Interface2 i2 = (Interface2) proxy;
        i2.method2();
    }
}

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}