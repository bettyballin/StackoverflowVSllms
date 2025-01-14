import java.lang.String;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeySimulator {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        
        // Simulate pressing and releasing keys from 'A' to 'z'
        for (int i = KeyEvent.VK_A; i <= KeyEvent.VK_Z; i++) {
            robot.keyPress(i);
            robot.keyRelease(i);
            Thread.sleep(50); // Optional: Add a delay between key presses if needed
        }
    }
}