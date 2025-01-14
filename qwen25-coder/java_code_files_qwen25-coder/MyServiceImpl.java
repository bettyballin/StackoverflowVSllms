public class Main {
    public static void main(String[] args) {
        MyService original = new MyServiceImpl();
        MyService synchronizedVersion = SynchronizationWrapper.wrap(original, MyService.class);
        synchronizedVersion.doSomething();  // This method call is now synchronized.
    }
}

interface MyService {
    void doSomething();
}

class MyServiceImpl implements MyService {
    @Override
    public void doSomething() {
        // implementation here
        System.out.println("Doing something...");
    }
}

class SynchronizationWrapper {
    @SuppressWarnings("unchecked")
    public static <T> T wrap(T obj, Class<T> cls) {
        return (T) java.lang.reflect.Proxy.newProxyInstance(
            cls.getClassLoader(),
            new Class<?>[] { cls },
            new SynchronizedInvocationHandler(obj)
        );
    }

    private static class SynchronizedInvocationHandler implements java.lang.reflect.InvocationHandler {
        private final Object target;

        public SynchronizedInvocationHandler(Object target) {
            this.target = target;
        }

        public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
            synchronized (target) {
                return method.invoke(target, args);
            }
        }
    }
}