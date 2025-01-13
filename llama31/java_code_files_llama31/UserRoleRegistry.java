/*
 * Decompiled with CFR 0.152.
 */
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserRoleRegistry {
    private Map<String, Set<Principal>> userRoles = new HashMap<String, Set<Principal>>();

    public void registerUserRoles(String string, Set<Principal> set) {
        this.userRoles.put(string, set);
    }

    public Set<Principal> getUserRoles(String string) {
        return this.userRoles.get(string);
    }

    public static void main(String[] stringArray) {
    }
}
