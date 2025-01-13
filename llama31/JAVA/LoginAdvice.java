import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoginAdvice {
    
    @Pointcut("@annotation(com.xxx.annotations.LoginRequired)")
    public void loginRequired() {
    }
    
    @Around("loginRequired()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // Your advice code here
        if (/* authentication logic */) {
            return joinPoint.proceed();
        } else {
            // forward to login page
            return null; // or throw an exception, or return a specific value
        }
    }
}