import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DebugAspect {
    @Pointcut("execution(* myMethod(..))")
    public void myMethod() {}

    @Before("myMethod()")
    public void logMethodEntry() {
        System.out.println("Entering myMethod");
    }

    @After("myMethod()")
    public void logMethodExit() {
        System.out.println("Exiting myMethod");
    }

    public static void main(String[] args) {
    }
}