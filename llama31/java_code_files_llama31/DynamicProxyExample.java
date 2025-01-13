/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] stringArray) {
        final Target target = new Target();
        Target target2 = (Target)Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, new InvocationHandler(){

            @Override
            public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
                System.out.println("Before invoking method");
                Object object2 = method.invoke((Object)target, objectArray);
                System.out.println("After invoking method");
                return object2;
            }
        });
        target2.doSomething();
    }
}
