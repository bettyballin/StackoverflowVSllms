import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FileProxy {
    private final File delegate;

    public FileProxy(String pathname) {
        delegate = new File(resolveShortcut(pathname));
    }

    private String resolveShortcut(String pathname) {
        // implement your Windows shortcut resolution logic here
        return pathname;
    }

    private static class FileProxyHandler implements InvocationHandler {
        private final File delegate;

        public FileProxyHandler(File delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(delegate, args);
        }
    }

    public static File createProxy(String pathname) {
        FileProxyHandler handler = new FileProxyHandler(new FileProxy(pathname));
        return (File) Proxy.newProxyInstance(File.class.getClassLoader(), new Class<?>[] { File.class }, handler);
    }

	public static void main(String[] args) {
	}
}