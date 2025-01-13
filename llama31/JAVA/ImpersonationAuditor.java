import java.lang.String;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;

public class ImpersonationAuditor {

    // Assuming auditService is an object of a class with a method logImpersonationAction
    public void logImpersonationAction(AuditService auditService) {
        // Log all actions performed during impersonation
        if (SecurityContextHolder.getContext().getAuthentication().isImpersonating()) {
            auditService.logImpersonationAction(
                SecurityContextHolder.getContext().getAuthentication().getName(),
                ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId(),
                "action performed");
        }
    }

    public static void main(String[] args) {
        ImpersonationAuditor auditor = new ImpersonationAuditor();
        // Assuming AuditService is a class with a method logImpersonationAction
        AuditService auditService = new AuditService();
        auditor.logImpersonationAction(auditService);
    }
}

// Assuming the User class exists
class User {
    public String getId() {
        // Implementation to get the user ID
        return "user-id";
    }
}

// Assuming the AuditService class exists
class AuditService {
    public void logImpersonationAction(String userName, String userId, String action) {
        // Implementation to log the impersonation action
        System.out.println("Logged impersonation action for user " + userName + " with ID " + userId + ": " + action);
    }
}