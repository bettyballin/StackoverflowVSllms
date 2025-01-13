import org.springframework.web.context.request.RequestContextHolder;

public class SessionScopeChecker_1 {
    public static void main(String[] args) {
        if (RequestContextHolder.getRequestAttributes() != null) {
            System.out.println("Session scope is likely active");
        } else {
            System.out.println("Session scope is not active, returning mock User object");
        }
    }
}