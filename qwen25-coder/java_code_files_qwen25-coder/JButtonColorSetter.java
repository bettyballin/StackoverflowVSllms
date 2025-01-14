import javax.swing.JButton;
import javax.swing.UIManager;

public class JButtonColorSetter {
    // Example in Java Swing
    JButton button = new JButton("Click Me");
    {
        button.setBackground(UIManager.getColor("control"));
    }

    public static void main(String[] args) {
    }
}