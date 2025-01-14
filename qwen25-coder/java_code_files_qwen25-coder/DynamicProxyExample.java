import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void sayHello();
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler(new RealSubject());
        
        // Create a proxy instance
        Hello proxyInstance = (Hello) Proxy.newProxyInstance(
            DynamicProxyExample.class.getClassLoader(),
            new Class<?>[]{Hello.class},
            handler
        );
        
        // This method call is intercepted by the invocation handler
        proxyInstance.sayHello();
    }
}

class RealSubject implements Hello {
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private final Object subject;
    
    public MyInvocationHandler(Object subject) {
        this.subject = subject;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before calling the real method...");
        Object result = method.invoke(subject, args);
        System.out.println("After calling the real method...");
        return result;
    }
}