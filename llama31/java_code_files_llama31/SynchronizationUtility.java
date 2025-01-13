/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationUtility {
    public static <T> T synchronize(T t) {
        ReentrantLock reentrantLock = new ReentrantLock();
        return (T)Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), (InvocationHandler)new SynchronizingHandler(t, reentrantLock));
    }

    public static void main(String[] stringArray) {
    }

    private static class SynchronizingHandler
    implements InvocationHandler {
        private final Object instance;
        private final ReentrantLock lock;

        public SynchronizingHandler(Object object, ReentrantLock reentrantLock) {
            this.instance = object;
            this.lock = reentrantLock;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
            this.lock.lock();
            try {
                Object object2 = method.invoke(this.instance, objectArray);
                return object2;
            }
            finally {
                this.lock.unlock();
            }
        }
    }
}
