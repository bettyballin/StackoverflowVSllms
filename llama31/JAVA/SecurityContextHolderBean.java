import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHolderBean {
    @Value("#{ securityContextHolder.getContext() }")
    private SecurityContext securityContext;

    public static void main(String[] args) {
    }
}