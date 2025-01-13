public class Permission {
    public static final int VIEWUSERS = 1;
    public static final int EDITUSERS = 2;

    public static int combinePermissions(int... permissions) {
        int combined = 0;
        for (int permission : permissions) {
            combined |= permission;
        }
        return combined;
    }

    public static boolean hasPermission(int storedValue, int permission) {
        return (storedValue & permission) == permission;
    }

    public static void main(String[] args) {
        int storedValue = Permission.combinePermissions(Permission.VIEWUSERS, Permission.EDITUSERS);
        System.out.println(storedValue); // Output: 3

        boolean hasEditUsersPermission = Permission.hasPermission(storedValue, Permission.EDITUSERS);
        System.out.println(hasEditUsersPermission); // Output: true
    }
}