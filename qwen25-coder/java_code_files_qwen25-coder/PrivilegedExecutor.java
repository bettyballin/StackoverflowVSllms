import java.lang.reflect.*;
import java.util.concurrent.*;

public class PrivilegedExecutor {
    private final Object target;
    private final ExecutorService executor;

    public PrivilegedExecutor(Object target) {
        this.target = target;
        // Use a single thread executor to maintain privilege.
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void invokeMethod(String methodName, Class<?>[] parameterTypes, Object[] parameters) throws Exception {
        Method method = this.target.getClass().getMethod(methodName, parameterTypes);

        Callable<Object> task = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return method.invoke(target, parameters);
            }
        };

        Future<Object> future = executor.submit(task);

        try {
            future.get(); // Wait for the privileged operation to finish.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw new RuntimeException("Method invocation failed", e.getCause());
        }
    }

    public void shutdown() {
        executor.shutdownNow();
    }

    // Usage Example within a main method
    public static void main(String[] args) throws Exception {
        // Create an instance of the target object
        MyObject myObject = new MyObject();
        
        // Create a PrivilegedExecutor with the target object
        PrivilegedExecutor priv = new PrivilegedExecutor(myObject);
        
        // Invoke method "myMethod" with no parameters
        priv.invokeMethod("myMethod", new Class<?>[]{}, new Object[]{});
        
        // Shutdown the executor to clean up resources
        priv.shutdown();
    }
}

// Target class with the method to be invoked
class MyObject {
    public void myMethod() {
        System.out.println("myMethod called");
    }
}