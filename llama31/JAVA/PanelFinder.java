import java.awt.Component;
import javax.swing.JPanel;

public class PanelFinder {
    private JPanel dynamicPanel;

    public PanelFinder() {
        for (Component c : getContentPane().getComponents()) {
            if (c instanceof JPanel && c.getName().equals("dynamicPanel")) {
                dynamicPanel = (JPanel) c;
                break;
            }
        }
    }

    public JPanel getDynamicPanel() {
        return dynamicPanel;
    }

    public static void main(String[] args) {
        PanelFinder finder = new PanelFinder();
    }

    // Assuming this method is already implemented somewhere in the original code
    public java.awt.Container getContentPane() {
        // Implementation here...
        return null;
    }
}