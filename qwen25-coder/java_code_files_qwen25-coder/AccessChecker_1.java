import java.lang.String;
public class AccessChecker_1 {

    public static final int ADMIN = 1;
    public static final int EDITOR = 2;
    public static final int GUEST = 3;

    public String checkUserAccess(int role, int permissionLevel) {
        if (role == ADMIN) {
            return "Full Access";
        } else {
            if (role == EDITOR) {
                if (permissionLevel >= 2) {
                    return "Edit Access";
                } else {
                    return "Read Only";
                }
            } else {
                if (role == GUEST) {
                    return "No Access";
                } else {
                    return "Unknown Role";
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}