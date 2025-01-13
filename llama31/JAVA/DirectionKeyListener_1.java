import java.lang.String;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DirectionKeyListener_1 implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                System.out.println("Up arrow pressed");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down arrow pressed");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left arrow pressed");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right arrow pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
	}
}