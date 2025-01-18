import java.lang.String;
import java.awt.*;
import java.awt.event.KeyEvent;
// Needed to work with Robot class for simulating keyboard inputs
public class Main_136 {
    public static void main(String[] args) throws AWTException, InterruptedException {
        // Creating a robot instance to send key events
        Robot robot = new Robot();
        robot.setAutoDelay(10); // Wait 10ms in between each keystroke
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c); // Get appropriate keycode for the character
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
}