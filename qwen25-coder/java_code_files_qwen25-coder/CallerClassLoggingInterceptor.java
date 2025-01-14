import java.lang.String;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public class CallerClassLoggingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // Get the stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        
        // Find the caller - typically it will be at index 4 or 5, but this can vary depending on the JVM and JDK version.
        String callerClassName = "";
        if (stackTrace.length > 4) {
            callerClassName = stackTrace[4].getClassName();
        }

        System.out.println("Caller class: " + callerClassName);

        // Proceed with the invocation
        return invocation.proceed();
    }

    public static void main(String[] args) {
    }
}

interface Interceptor {
}

interface MethodInterceptor extends Interceptor {
    Object invoke(MethodInvocation invocation) throws Throwable;
}

interface Invocation {
}

interface MethodInvocation extends Invocation {
    Method getMethod();
    Object[] getArguments();
    Object proceed() throws Throwable;
    Object getThis();
    AccessibleObject getStaticPart();
}