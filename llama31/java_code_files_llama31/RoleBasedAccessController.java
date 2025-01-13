/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.core.context.SecurityContextHolder
 */
import org.springframework.security.core.context.SecurityContextHolder;

public class RoleBasedAccessController {
    public static void main(String[] stringArray) {
        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("SUPPORT"))) {
            System.out.println("Access granted for support personnel.");
        } else {
            System.out.println("Access denied.");
        }
    }
}
