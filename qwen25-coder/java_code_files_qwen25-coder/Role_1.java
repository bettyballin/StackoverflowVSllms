import java.util.Set;

public enum Permission {
    READ,
    WRITE,
    DELETE,
    // Add more permissions as needed
}

public class Role_1 {
    private final String name;
    private final Set<Permission> permissions;

    public Role_1(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }
}

public class Main {
    public static void main(String[] args) {
    }
}