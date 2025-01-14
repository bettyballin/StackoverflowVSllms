import java.lang.String;
// Example of simple logging using AOP
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;

@Aspect
public class LoggingAspect {
    @Before("execution(* com.yourpackage.YourClass.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Called method: " + joinPoint.getSignature().getName());
        for (Object arg : joinPoint.getArgs()) {
            System.out.println("Argument: " + arg);
        }
    }

    public static void main(String[] args) {
    }
}