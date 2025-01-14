import java.lang.String;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKeyExample extends JFrame {
    public ArrowKeyExample() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        System.out.println("Up arrow was pressed");
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("Down arrow was pressed");
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("Left arrow was pressed");
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("Right arrow was pressed");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrowKeyExample ex = new ArrowKeyExample();
            ex.setVisible(true);
        });
    }
}