import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

public class MyPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String permissionString) {
        return new WildcardPermission(permissionString);
    }
}

public class Main_357 {
    public static void main(String[] args) {
        PermissionResolver permissionResolver = new MyPermissionResolver();
        Permission permission = permissionResolver.resolvePermission("permissionString");
        System.out.println(permission);
    }
}