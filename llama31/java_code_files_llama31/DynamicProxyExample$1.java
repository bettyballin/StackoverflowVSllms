/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

static class DynamicProxyExample.1
implements InvocationHandler {
    final /* synthetic */ Target val$target;

    DynamicProxyExample.1(Target target) {
        this.val$target = target;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        System.out.println("Before invoking method");
        Object object2 = method.invoke((Object)this.val$target, objectArray);
        System.out.println("After invoking method");
        return object2;
    }
}
