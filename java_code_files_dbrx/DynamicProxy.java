import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {

    InvocationHandler invocationHandler = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Your custom logic here based on invoked method and arguments.
            return null;
        }
    };

    Class<?> interfaces[] = { SomeInterface1.class, SomeInterface2.class };

    T myProxy = (T) Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, invocationHandler);

    public static void main(String[] args) {
    }
}

interface SomeInterface1 {
}

interface SomeInterface2 {
}