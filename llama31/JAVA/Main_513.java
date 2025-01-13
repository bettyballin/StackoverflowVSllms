import com.sun.jna.Library;
import com.sun.jna.Native;

public class Main_513 {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load("c", CLibrary.class);

        int access(String pathname, int mode);
        int getuid();
    }

    public static void main(String[] args) {
        // Get the logged-in user's UID
        int uid = CLibrary.INSTANCE.getuid();

        // Check if user1 has read permission on /home/user2
        int result = CLibrary.INSTANCE.access("/home/user2", 0400); // R_OK
        if (result == 0) {
            // user1 has read permission on /home/user2
            System.out.println("user1 has read permission on /home/user2");
        } else {
            System.out.println("user1 does not have read permission on /home/user2");
        }
    }
}