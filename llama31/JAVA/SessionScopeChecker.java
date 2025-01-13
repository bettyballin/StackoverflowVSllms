import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionScopeChecker {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SessionScopeChecker.class);
        Scope sessionScope = applicationContext.getScope("session");

        if (sessionScope != null && sessionScope.isActive()) {
            // Session scope is active
            System.out.println("Session scope is active");
        } else {
            // Session scope is not active, return mock User object
            System.out.println("Session scope is not active");
        }
    }
}