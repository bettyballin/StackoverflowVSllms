import java.util.*;

class Permission {
    private String name;
    // Add any other attributes necessary

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Role {
    private String name;
    private Set<Permission> permissions;

    public Role(String name) {
        this.name = name;
        this.permissions = new HashSet<>();
    }

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }
}

class User {
    private String username;
    private Set<Role> roles;

    public User(String username) {
        this.username = username;
        this.roles = new HashSet<>();
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasPermission(Permission permission) {
        for (Role role : roles) {
            if (role.hasPermission(permission)) {
                return true;
            }
        }
        return false;
    }
}

// Renamed to avoid conflict with java.lang.SecurityManager
class MySecurityManager {
    public boolean canUserPerformAction(User user, Permission action) {
        return user.hasPermission(action);
    }
}

// Example usage
public class GuiApp {
    public static void main(String[] args) {
        Permission printPermission = new Permission("PRINT");
        Permission deletePermission = new Permission("DELETE");

        Role adminRole = new Role("ADMIN");
        adminRole.addPermission(printPermission);
        adminRole.addPermission(deletePermission);

        Role userRole = new Role("USER");
        userRole.addPermission(printPermission);

        User adminUser = new User("admin");
        adminUser.addRole(adminRole);

        User normalUser = new User("user");
        normalUser.addRole(userRole);

        MySecurityManager securityManager = new MySecurityManager();
        System.out.println("Admin can print: " + securityManager.canUserPerformAction(adminUser, printPermission));
        System.out.println("Normal user can delete: " + securityManager.canUserPerformAction(normalUser, deletePermission));
    }
}