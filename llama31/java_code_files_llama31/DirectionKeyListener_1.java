/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DirectionKeyListener_1
implements KeyListener {
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        switch (n) {
            case 38: {
                System.out.println("Up arrow pressed");
                break;
            }
            case 40: {
                System.out.println("Down arrow pressed");
                break;
            }
            case 37: {
                System.out.println("Left arrow pressed");
                break;
            }
            case 39: {
                System.out.println("Right arrow pressed");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    public static void main(String[] stringArray) {
    }
}
