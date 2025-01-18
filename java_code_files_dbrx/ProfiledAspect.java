import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import your_package_here.Profiled;
import your_package_here.Profiler;

@Aspect
public class ProfiledAspect { 
    @Around("execution(@your_package_here.Profiled * *(..)) && @annotation(profiledAnn)")
    public Object profileMethodExecution(final ProceedingJoinPoint joinPoint, final Profiled profiledAnn) throws Throwable {
        String logicalEventType = profiledAnn.value(); // Extract the value from @Profiled
        Profiler.startEvent(logicalEventType);  // Start the profiling event
        try { 
            return joinPoint.proceed(); 
        } finally { 
            // Ensure the end event is called even if an exception occurs.
            Profiler.endEvent(logicalEventType); // End the profiling event.
        }
    }   
}