import java.lang.String;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardSimulator {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        for (char c = 'A'; c <= 'Z'; c++) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }
    }
}