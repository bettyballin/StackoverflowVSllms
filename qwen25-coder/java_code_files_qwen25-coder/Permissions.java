import java.lang.String;
public class Permissions {
    public static final int VIEWUSERS = 1;       // 2^0 // 0000 0001
    public static final int EDITUSERS = 2;       // 2^1 // 0000 0010
    public static final int VIEWPRODUCTS = 4;    // 2^2 // 0000 0100
    public static final int EDITPRODUCTS = 8;    // 2^3 // 0000 1000
    public static final int VIEWCLIENTS = 16;    // 2^4 // 0001 0000
    public static final int EDITCLIENTS = 32;    // 2^5 // 0010 0000
    public static final int DELETECLIENTS = 64;  // 2^6 // 0100 0000

    // Method to check if a user has a specific permission
    public static boolean hasPermission(int userPermissions, int permission) {
        return (userPermissions & permission) == permission;
    }

    // Method to add a permission to a user's existing permissions
    public static int addPermission(int userPermissions, int permission) {
        return userPermissions | permission;
    }

	public static void main(String[] args) {
	}
}