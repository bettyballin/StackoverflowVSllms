import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class KeyEventListener {
    private Display display;

    public KeyEventListener() {
        display = new Display();
    }

    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();
        String message;

        switch (code) {
            case KeyEvent.VK_UP:
                message = "Up";
                break;
            case KeyEvent.VK_DOWN:
                message = "Down";
                break;
            case KeyEvent.VK_LEFT:
                message = "Left";
                break;
            case KeyEvent.VK_RIGHT:
                message = "Right";
                break;
            default:
                message = String.valueOf(event.getKeyChar());
                break;
        }
        display.keyLabel.setText("Code: " + code + " Symbol: " + message);
        display.repaint();
    }

    public static void main(String[] args) {
        // Entry point of the program
    }

    // Inner class representing the display
    class Display {
        public JLabel keyLabel;

        public Display() {
            keyLabel = new JLabel();
        }

        public void repaint() {
            // Code to repaint the display
        }
    }
}