/*
 * Decompiled with CFR 0.152.
 */
import java.security.Principal;

class YourPrincipalImplemention
implements Principal {
    private String[] roles;

    public YourPrincipalImplemention(String[] stringArray) {
        this.roles = stringArray;
    }

    public String[] getRoles() {
        return this.roles;
    }

    @Override
    public String getName() {
        return null;
    }
}
