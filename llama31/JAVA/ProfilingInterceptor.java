import java.lang.reflect.Method;
import org.jboss.aop.Interceptor;
import org.jboss.aop.Invocation;
import org.jboss.aop.InvocationContext;
import org.jboss.aop.advice.InterceptorFactory;
import org.jboss.aop.advice.InterceptorFactoryFinder;
import org.jboss.aop.proxy.container.AspectManaged;
import org.jboss.aop.proxy.container.Container;

public class ProfilingInterceptor implements Interceptor {
    @Override
    public String getName() {
        return "ProfilingInterceptor";
    }

    @Override
    public Object invoke(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.invokeNext();
        } finally {
            long endTime = System.currentTimeMillis();
            // log or store the execution time
            System.out.println("Method " + invocation.getMethod().getName() + " took " + (endTime - startTime) + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of the interceptor
        ProfilingInterceptor interceptor = new ProfilingInterceptor();

        // Create a container and add the interceptor
        Container container = new Container();
        InterceptorFactory factory = InterceptorFactoryFinder.findFactory(ProfilingInterceptor.class);
        container.addInterceptor(factory);

        // Create an instance of a test class
        TestClass test = new TestClass();

        // Create an aspect-managed instance of the test class
        AspectManaged managed = container.createManagedInstance(test, TestClass.class);

        // Invoke a method on the test class
        Method method = TestClass.class.getMethod("testMethod");
        managed.invoke(method);
    }
}

class TestClass {
    public void testMethod() {
        // Simulate some work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}