/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

class Group {
    private String name;
    private Map<String, Role> roles;

    public Group(String string) {
        this.name = string;
        this.roles = new HashMap<String, Role>();
    }

    public void addRole(Role role) {
        this.roles.put(role.getName(), role);
    }

    public String getName() {
        return this.name;
    }
}
