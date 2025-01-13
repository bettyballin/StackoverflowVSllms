import java.lang.String;

// Assuming Role is a custom class, you need to define it or import it
class Role {
    public boolean isVisible(Object authUser) {
        // You need to implement this method according to your logic
        return true; // for example
    }
}

public class RoleFunctions {
    public static boolean isVisible(Role role, Object authUser) {
        return role.isVisible(authUser);
    }

    public static void main(String[] args) {
    }
}