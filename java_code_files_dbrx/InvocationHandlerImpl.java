import java.lang.reflect.*;

interface MyInterface {
    void doSomething();
}

class MyOtherObj {
    // Empty class
}

class InvocationHandlerImpl implements InvocationHandler {
    Object obj;

    public InvocationHandlerImpl(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}

public class DynamicProxyTest {
    public static void main(String args[]) {
        InvocationHandler handler = new InvocationHandlerImpl(new MyOtherObj());
        MyInterface mi = (MyInterface) Proxy.newProxyInstance(
            DynamicProxyTest.class.getClassLoader(),
            new Class<?>[] { MyInterface.class },
            handler
        );
    }
}