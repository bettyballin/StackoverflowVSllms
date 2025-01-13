/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.authentication.AuthenticationManager
 *  org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.AuthenticationException
 *  org.springframework.security.core.authority.SimpleGrantedAuthority
 */
import java.util.ArrayList;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

class MockAuthenticationManager
implements AuthenticationManager {
    MockAuthenticationManager() {
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ArrayList<SimpleGrantedAuthority> arrayList = new ArrayList<SimpleGrantedAuthority>();
        arrayList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), arrayList);
    }
}
