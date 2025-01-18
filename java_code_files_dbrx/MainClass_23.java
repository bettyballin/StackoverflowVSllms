import java.lang.reflect.*;

public class MainClass {

    public interface MyInterface {
        String sayHello();
    }

    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return "Hello World!";
            }
        };
        Class<?> cls = Proxy.getProxyClass(MyInterface.class.getClassLoader(), MyInterface.class);
        Constructor<?> constructor = cls.getConstructor(InvocationHandler.class);
        MyInterface instance = (MyInterface) constructor.newInstance(handler); // create an instance dynamically at runtime
        System.out.println("Dynamic proxy: " + instance.sayHello()); // prints 'Dynamic proxy: Hello World!'
    }
}