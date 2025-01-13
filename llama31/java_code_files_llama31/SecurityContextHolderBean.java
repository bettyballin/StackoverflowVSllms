/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.security.core.context.SecurityContext
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;

public class SecurityContextHolderBean {
    @Value(value="#{ securityContextHolder.getContext() }")
    private SecurityContext securityContext;

    public static void main(String[] stringArray) {
    }
}
