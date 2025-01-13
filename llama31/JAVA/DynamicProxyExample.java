import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create a target object
        Target target = new Target();

        // Create a dynamic proxy
        Target proxy = (Target) Proxy.newProxyInstance(
                Target.class.getClassLoader(),
                new Class[]{Target.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before invoking method");
                        Object result = method.invoke(target, args);
                        System.out.println("After invoking method");
                        return result;
                    }
                }
        );

        // Use the dynamic proxy
        proxy.doSomething();
    }
}

class Target {
    public void doSomething() {
        System.out.println("Doing something");
    }
}