#include <stdio.h>

// Define an enumeration for the permissions
typedef enum {
    EDIT_PERMISSION        = 0x00000001,  // Edit permission
    CREATE_NEW_PERMISSION  = 0x00000002,  // Create new thing permission
    DELETE_PERMISSION      = 0x00000004,  // Delete things permission
    VIEW_HIDDEN_PERMISSION = 0x00000008,  // View hidden things permission
    // Add more permissions as needed...
    TOTAL_CONTROL_PERMISSION = 0x80000000  // Total control of the server and everyone logged in
} Permission;

int main() {
    // Example usage:
    Permission userPermission = EDIT_PERMISSION | CREATE_NEW_PERMISSION;
    printf("User permission: 0x%08x\n", userPermission);
    return 0;
}