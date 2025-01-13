import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextOnKeyDown implements KeyListener {
    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        // ...
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // ...
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // ...
    }
}