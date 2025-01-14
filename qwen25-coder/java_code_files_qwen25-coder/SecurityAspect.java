import java.lang.String;
import java.lang.annotation.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

// Define a dummy Component annotation to replace Spring's Component
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {
}

// Define the Secured annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Secured {
    String role();
}

// Define a dummy ProceedingJoinPoint interface to replace AspectJ's ProceedingJoinPoint
interface ProceedingJoinPoint {
    Object proceed() throws Throwable;
}

@Aspect
@Component
public class SecurityAspect {

    @Around("@annotation(secured)")
    public Object applySecurity(ProceedingJoinPoint joinPoint, Secured secured) throws Throwable {
        // Example role checking logic - typically use a service to get user info and roles
        String requiredRole = secured.role();
        String userRole = "user"; // Simplified for example

        if (requiredRole.equals(userRole)) {
            return joinPoint.proceed(); // Allow access if the user's role matches
        } else {
            throw new SecurityException("Access Denied");
        }
    }

    public static void main(String[] args) {
        // Example usage
        SecurityAspect aspect = new SecurityAspect();
        try {
            Object result = aspect.applySecurity(new ProceedingJoinPoint() {
                @Override
                public Object proceed() {
                    System.out.println("Access Granted");
                    return null;
                }
            }, new Secured() {
                @Override
                public String role() {
                    return "user";
                }

                @Override
                public Class<? extends Annotation> annotationType() {
                    return Secured.class;
                }
            });
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}