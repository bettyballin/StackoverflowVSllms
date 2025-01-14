import java.lang.String;
public class AccessController {
    public static final int ADMIN = 1;
    public static final int EDITOR = 2;
    public static final int GUEST = 3;

    public String checkUserAccess(int role, int permissionLevel) {
        switch (role) {
            case ADMIN:
                return "Full Access";
            case EDITOR:
                if (permissionLevel >= 2) {
                    return "Edit Access";
                } else {
                    return "Read Only";
                }
            case GUEST:
                return "No Access";
            default:
                return "Unknown Role";
        }
    }
    public static void main(String[] args) {
    }
}