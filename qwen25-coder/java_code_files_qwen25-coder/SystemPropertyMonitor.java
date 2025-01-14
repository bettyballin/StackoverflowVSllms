import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SystemPropertyMonitor {

    @Around("execution(* java.lang.System.setProperty(..))")
    public Object logAroundSetProperty(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = (String) joinPoint.getArgs()[0];
        String value = (String) joinPoint.getArgs()[1];
        
        System.out.println("System property change detected: " + key + " set to '" + value + "'");
        
        return joinPoint.proceed();
    }

    public static void main(String[] args) {
    }
}