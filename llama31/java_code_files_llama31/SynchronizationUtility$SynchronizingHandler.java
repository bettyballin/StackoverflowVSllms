/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

private static class SynchronizationUtility.SynchronizingHandler
implements InvocationHandler {
    private final Object instance;
    private final ReentrantLock lock;

    public SynchronizationUtility.SynchronizingHandler(Object object, ReentrantLock reentrantLock) {
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
