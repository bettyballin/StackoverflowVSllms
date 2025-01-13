import java.lang.String;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CallerLoggingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String callerClassName = stackTrace[2].getClassName();
        System.out.println("Caller class: " + callerClassName);
        return invocation.proceed();
    }

    public static void main(String[] args) {
    }
}