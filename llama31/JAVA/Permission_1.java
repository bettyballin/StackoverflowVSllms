import java.lang.String;

public class Permission_1_1 {
    public enum Permission {
        VIEWUSERS(1),
        EDITUSERS(2),
        VIEWPRODUCTS(4),
        EDITPRODUCTS(8),
        VIEWCLIENTS(16),
        EDITCLIENTS(32),
        DELETECLIENTS(64);

        private final int value;

        Permission(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static int combinePermissions(Permission... permissions) {
            int result = 0;
            for (Permission permission : permissions) {
                result |= permission.getValue();
            }
            return result;
        }

        public static boolean hasPermission(int storedValue, Permission permission) {
            return (storedValue & permission.getValue()) != 0;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int combinedPermissions = Permission.combinePermissions(Permission.VIEWUSERS, Permission.EDITUSERS);
        System.out.println("Combined permissions: " + combinedPermissions);

        boolean hasViewUsersPermission = Permission.hasPermission(combinedPermissions, Permission.VIEWUSERS);
        System.out.println("Has VIEWUSERS permission: " + hasViewUsersPermission);
    }
}