import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

@Aspect
public class LogExecutionTimeAdvice implements Ordered {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  public Object logExecutionTime(final ProceedingJoinPoint proceedingJoinPoint, final String methodName) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(methodName);
        try{
            return proceedingJoinPoint.proceed(); // Proceed with the normal flow
        }finally{
            stopWatch.stop();
            log.info("Execution time for " + methodName + ": " +  stopWatch.prettyPrint());
        }
    }

  @Around(value = "@annotation(LogExecutionTime)")
    public Object aroundAdvice(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      return logExecutionTime(proceedingJoinPoint, "Method call");
   }

   @Override
   public int getOrder() {
       return 0;
   }

	public static void main(String[] args) {
	}
}