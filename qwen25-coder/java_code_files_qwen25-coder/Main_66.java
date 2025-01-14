import com.sun.jna.*;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;

public class Main_66 {
    public static void main(String[] args) {
        // Check if Alt key is held down on startup
        boolean isAltKeyDown = (User32.INSTANCE.GetKeyState(VK.VK_MENU) & 0x8000) != 0;
        
        if (!isAltKeyDown) {
            // Show resolution dialog with checkbox to turn it off
            System.out.println("Displaying resolution selection dialog.");
            // Call method to show your dialog here
        } else {
            System.out.println("Alt key is held down. Skipping the dialog.");
        }
    }

    public static class VK {
        public static final int VK_MENU = 0x12; // Alt key
    }
}