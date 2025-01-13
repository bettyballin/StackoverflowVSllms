import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextOnKeyDown_1 implements KeyListener {

    private String prefix;

    public TextOnKeyDown(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Add your logic here...
        System.out.println("Key pressed: " + key);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        // Example usage:
        TextOnKeyDown onKeyDown = new TextOnKeyDown("prefix");
        // Create a JFrame and add a JTextField to test the KeyListener
        javax.swing.JFrame frame = new javax.swing.JFrame();
        javax.swing.JTextField textField = new javax.swing.JTextField();
        frame.getContentPane().add(textField);
        textField.addKeyListener(onKeyDown);
        frame.pack();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}