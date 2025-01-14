import java.lang.String;
import java.awt.AWTException;
import java.awt.Robot;

public class MouseController {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        
        // Move mouse to (x, y)
        int x = 100;
        int y = 150;
        robot.mouseMove(x, y);
        
        // Perform a mouse click
        robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
    }
}