import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ComponentRemover {
    private JPanel panel;

    public ComponentRemover() {
        panel = new JPanel(new BorderLayout());
        // ... add components to the panel ...
        panel.remove(BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new ComponentRemover();
    }
}