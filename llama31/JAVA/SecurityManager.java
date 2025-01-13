import java.util.HashMap;
import java.util.Map;

// Define the Group class
class Group {
    private String name;
    private Map<String, Role> roles;

    public Group(String name) {
        this.name = name;
        this.roles = new HashMap<>();
    }

    public void addRole(Role role) {
        this.roles.put(role.getName(), role);
    }

    public String getName() {
        return name;
    }
}

// Define the Role class
class Role {
    private String name;
    private Map<String, Permission> permissions;

    public Role(String name) {
        this.name = name;
        this.permissions = new HashMap<>();
    }

    public void addPermission(Permission permission) {
        this.permissions.put(permission.getName(), permission);
    }

    public String getName() {
        return name;
    }
}

// Define the Permission class
class Permission {
    private String name;

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class SecurityManager {
    private Map<String, Group> groups;
    private Map<String, Role> roles;
    private Map<String, Permission> permissions;

    public SecurityManager() {
        this.groups = new HashMap<>();
        this.roles = new HashMap<>();
        this.permissions = new HashMap<>();
    }

    public boolean hasPermission(Role role, Permission permission) {
        // Check if the role has the permission directly or through its groups
        if (role.permissions.containsKey(permission.getName())) {
            return true;
        }
        for (Group group : groups.values()) {
            if (group.roles.containsKey(role.getName()) && group.roles.get(role.getName()).permissions.containsKey(permission.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addRoleToGroup(Role role, Group group) {
        // Add the role to the group and update the role's permissions
        group.addRole(role);
        for (Permission permission : permissions.values()) {
            if (group.roles.containsKey(role.getName()) && group.roles.get(role.getName()).permissions.containsKey(permission.getName())) {
                role.addPermission(permission);
            }
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        // Example usage:
        Role role = new Role("admin");
        Group group = new Group("administrators");
        Permission permission = new Permission("read");
        securityManager.addRoleToGroup(role, group);
        System.out.println(securityManager.hasPermission(role, permission));
    }
}