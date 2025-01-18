public class Main {
    public enum Permission {
        EDIT_USERS(1),
        DELETE_USERS(2),
        VIEW_USERS(4);
        // ... other permissions can be added here

        private int value;

        Permission(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static boolean hasPermission(int permissions, int permissionValue) {
            return (permissions & permissionValue) == permissionValue;
        }
    }

    public static void main(String[] args) {
        // Example user permission value from the database
        int userPermissionsValueFromDB = 5; // Binary 0101, which means EDIT_USERS and VIEW_USERS permissions

        // Example usage
        boolean canEditUsers = Permission.hasPermission(
            userPermissionsValueFromDB, 
            Permission.EDIT_USERS.getValue()
        );

        System.out.println("Can edit users: " + canEditUsers);
    }
}