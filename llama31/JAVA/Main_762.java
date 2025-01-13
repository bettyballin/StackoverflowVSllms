import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main_762 {
    public static void main(String[] args) {
        // Create a proxy object
        Object proxy = Proxy.newProxyInstance(
            Main.class.getClassLoader(),
            new Class[]{Runnable.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
                    // You should implement the invoke method
                    return null;
                }
            }
        );

        InvocationHandler handler = Proxy.getInvocationHandler(proxy);
        Object target = ((java.lang.reflect.Proxy$ProxyInvocationHandler) handler).getTarget();

        System.out.println(target);
    }
}