import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SynchronizationWrapper {
    public static <T> T wrap(T object, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            object.getClass().getClassLoader(),
            new Class<?>[]{interfaceType},
            new SynchronizingInvocationHandler(object)
        );
    }

    private static class SynchronizingInvocationHandler implements InvocationHandler {
        private final Object target;

        public SynchronizingInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            synchronized (target) {
                return method.invoke(target, args);
            }
        }
    }

	public static void main(String[] args) {
	}
}