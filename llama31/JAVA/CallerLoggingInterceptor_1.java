import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CallerLoggingInterceptor_1 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> callerClass = new SecurityManager() {
            @Override
            protected Class<?>[] getClassContext() {
                return super.getClassContext();
            }
        }.getClassContext()[1];
        System.out.println("Caller class: " + callerClass.getName());
        return invocation.proceed();
    }
}