/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.AuthenticationException
 *  org.springframework.security.core.context.SecurityContextHolder
 */
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

public class Main_624 {
    public static void main(String[] stringArray) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken((Object)"username", (Object)"password");
        MockAuthenticationManager mockAuthenticationManager = new MockAuthenticationManager();
        try {
            Authentication authentication = mockAuthenticationManager.authenticate((Authentication)usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Authenticated successfully.");
        }
        catch (AuthenticationException authenticationException) {
            System.out.println("Authentication failed: " + authenticationException.getMessage());
        }
    }
}
