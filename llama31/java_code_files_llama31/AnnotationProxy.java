/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnnotationProxy
implements InvocationHandler {
    private Object target;

    public AnnotationProxy(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        Annotation[] annotationArray;
        Method method2 = this.target.getClass().getMethod(method.getName(), method.getParameterTypes());
        for (Annotation annotation : annotationArray = method2.getAnnotations()) {
        }
        return method.invoke(this.target, objectArray);
    }

    public static void main(String[] stringArray) {
        MyObject myObject = new MyObject();
        Object object = Proxy.newProxyInstance(myObject.getClass().getClassLoader(), myObject.getClass().getInterfaces(), (InvocationHandler)new AnnotationProxy(myObject));
    }
}
