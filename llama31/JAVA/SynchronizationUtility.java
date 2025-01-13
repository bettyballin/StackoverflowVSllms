import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationUtility {
    public static <T> T synchronize(T instance) {
        ReentrantLock lock = new ReentrantLock();
        return (T) Proxy.newProxyInstance(
                instance.getClass().getClassLoader(),
                instance.getClass().getInterfaces(),
                new SynchronizingHandler(instance, lock));
    }

    private static class SynchronizingHandler implements InvocationHandler {
        private final Object instance;
        private final ReentrantLock lock;

        public SynchronizingHandler(Object instance, ReentrantLock lock) {
            this.instance = instance;
            this.lock = lock;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            lock.lock();
            try {
                return method.invoke(instance, args);
            } finally {
                lock.unlock();
            }
        }
    }

	public static void main(String[] args) {
	}
}