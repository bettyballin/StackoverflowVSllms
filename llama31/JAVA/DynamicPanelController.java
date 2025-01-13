import javax.swing.JButton;
import javax.swing.JPanel;

public class DynamicPanelController {
    public static void main(String[] args) {
        DynamicPanelController controller = new DynamicPanelController();
    }

    public DynamicPanelController() {
        JButton button = new JButton("Click me!");
        JPanel dynamicPanel = new JPanel();
        dynamicPanel.add(button);
    }
}