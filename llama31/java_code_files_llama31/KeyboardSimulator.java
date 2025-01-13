/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardSimulator {
    public static void main(String[] stringArray) throws Exception {
        Robot robot = new Robot();
        for (int n = 65; n <= 90; n = (int)((char)(n + 1))) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(n));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(n));
        }
    }
}
