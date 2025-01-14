import java.lang.String;
public class UserPermissionsChecker {
    public static void main(String[] args) {
        if (Permissions.hasPermission(userPermissions, Permissions.VIEWUSERS)) {
            // The user can view users
        } else {
            // The user cannot view users
        }
    }
}