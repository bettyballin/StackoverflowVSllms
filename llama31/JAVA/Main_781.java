import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Main_781_781 {
    public static void main(String[] args) {
        // Check if the Alt key is being held down
        if (isAltKeyDown()) {
            // Show the resolution selection dialog
            System.out.println("Alt key is being held down");
        } else {
            // Don't show the dialog
            System.out.println("Alt key is not being held down");
        }
    }

    private static boolean isAltKeyDown() {
        // Get the current state of the Alt key
        int altKeyState = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_ALT);

        // If the Alt key is being held down, the state will be non-zero
        return altKeyState != 0;
    }
}