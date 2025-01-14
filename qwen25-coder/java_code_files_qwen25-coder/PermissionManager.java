import java.util.HashMap;
import java.util.Map;

public class PermissionManager {
    private Map<String, Integer> permissionMap = new HashMap<>();
    private int currentBitPosition = 0; // Start with bit 0

    public void addPermission(String permission) {
        if (!permissionMap.containsKey(permission)) {
            permissionMap.put(permission, (1 << currentBitPosition));
            currentBitPosition++;
        }
    }

    public int getPermissionsMask(Map<String, Integer> permissionsToAssign) {
        int mask = 0;
        for (String permission : permissionsToAssign.keySet()) {
            if (permissionMap.containsKey(permission)) {
                mask |= permissionMap.get(permission);
            }
        }
        return mask;
    }

    public boolean hasPermission(int permissionsGlob, String permissionToCheck) {
        Integer permissionMask = permissionMap.get(permissionToCheck);
        if (permissionMask == null) {
            return false; // Permission not registered
        }
        return (permissionsGlob & permissionMask) != 0;
    }

    public static void main(String[] args) {
        PermissionManager manager = new PermissionManager();

        // Add permissions
        manager.addPermission("read");
        manager.addPermission("write");
        manager.addPermission("delete");

        // Assign permissions to a user (can be represented by an integer)
        Map<String, Integer> userPermissions = new HashMap<>();
        userPermissions.put("read", 1); // Just placeholder values, we don't need them here
        userPermissions.put("write", 1);

        int userGlob = manager.getPermissionsMask(userPermissions);

        // Check permissions
        System.out.println("User can read: " + manager.hasPermission(userGlob, "read"));    // true
        System.out.println("User can write: " + manager.hasPermission(userGlob, "write"));  // true
        System.out.println("User can delete: " + manager.hasPermission(userGlob, "delete")); // false
    }
}