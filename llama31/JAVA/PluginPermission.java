import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Collections;

public class PluginPermission extends Permission {
    private String action;

    public PluginPermission(String name, String action) {
        super(name);
        this.action = action;
    }

    @Override
    public boolean implies(Permission permission) {
        // Check if the plug-in has the required permission
        return permission instanceof PluginPermission && permission.getName().equals(getName());
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return new PluginPermissionCollection();
    }

    @Override
    public String getActions() {
        return action;
    }

    public static void main(String[] args) {
        // Create an instance of PluginPermission
        PluginPermission permission = new PluginPermission("myPlugin", "read,write");
        System.out.println(permission.getActions());
    }
}

class PluginPermissionCollection extends PermissionCollection {
    private Permission permission;

    @Override
    public void add(Permission permission) {
        if (this.permission != null) {
            throw new SecurityException("Cannot add multiple permissions to this collection");
        }
        this.permission = permission;
    }

    @Override
    public boolean implies(Permission permission) {
        return this.permission.implies(permission);
    }

    @Override
    public Enumeration<Permission> elements() {
        return Collections.enumeration(Collections.singletonList(permission));
    }
}