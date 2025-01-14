import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class ExceptionAspect {
    @AfterThrowing(pointcut = "execution(* com.example..*(..))", throwing = "e")
    public void logException(Exception e) throws Throwable {
        // Log exception details, stack trace, etc.
    }

    public static void main(String[] args) {
    }
}