import java.lang.String;
public class RoleAssignmentManager {
    // Example of a role assignment in Java
    public static void main(String[] args) {
        Role adminRole = new Role("admin");
        adminRole.addPermission(new Permission("edit_user"));
        UserSupport userSupport = new UserSupport();
        userSupport.assignRole(adminRole);
    }
}