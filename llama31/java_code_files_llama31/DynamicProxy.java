/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy
implements InvocationHandler {
    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        System.out.println("Method invoked: " + method.getName());
        return null;
    }

    public static void main(String[] stringArray) {
        Class[] classArray = new Class[]{Interface1.class, Interface2.class};
        Object object = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), classArray, (InvocationHandler)new DynamicProxy());
        Interface1 interface1 = (Interface1)object;
        interface1.method1();
        Interface2 interface2 = (Interface2)object;
        interface2.method2();
    }
}
