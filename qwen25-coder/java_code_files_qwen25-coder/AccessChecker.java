import java.lang.String;
public class AccessChecker {
    public static final int ADMIN = 0;
    public static final int EDITOR = 1;
    public static final int GUEST = 2;

    public String checkUserAccess(int role, int permissionLevel) {
        if (role == ADMIN) {
            return "Full Access";
        }
        
        if (role == EDITOR && permissionLevel >= 2) {
            return "Edit Access";
        }
        
        if (role == EDITOR && permissionLevel < 2) {
            return "Read Only";
        }
    
        if (role == GUEST) {
            return "No Access";
        }
    
        return "Unknown Role"; 
    }
    	public static void main(String[] args) {
    	}
}