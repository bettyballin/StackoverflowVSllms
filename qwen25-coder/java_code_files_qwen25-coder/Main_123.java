public class Main {
    public static void main(String[] args) {
        int userPermissions = 0;
        
        // Add VIEWUSERS and EDITPRODUCTS to the user's permissions
        userPermissions = Permissions.addPermission(userPermissions, Permissions.VIEWUSERS);
        userPermissions = Permissions.addPermission(userPermissions, Permissions.EDITPRODUCTS);
        
        // Store `userPermissions` in your database as an integer.
        System.out.println("User Permissions: " + userPermissions);
    }
}

class Permissions {
    public static final int VIEWUSERS = 1 << 0;
    public static final int EDITPRODUCTS = 1 << 1;
    // You can define other permissions similarly

    public static int addPermission(int permissions, int permissionToAdd) {
        return permissions | permissionToAdd;
    }
}