/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyMonitor
extends KeyAdapter {
    KeyChecker display;

    KeyMonitor(KeyChecker keyChecker) {
        this.display = keyChecker;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        String string = "Unknown";
        switch (n) {
            case 38: {
                string = "Up";
                break;
            }
            case 40: {
                string = "Down";
                break;
            }
            case 37: {
                string = "Left";
                break;
            }
            case 39: {
                string = "Right";
            }
        }
        this.display.keyLabel.setText(string);
        this.display.repaint();
    }
}
