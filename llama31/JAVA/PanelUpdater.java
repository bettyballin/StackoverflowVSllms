import javax.swing.JPanel;

public class PanelUpdater {
    private static JPanel dynamicPanel = new JPanel(); // declare and initialize dynamicPanel

    public static void updatePanel() {
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    public static void main(String[] args) {
        updatePanel(); // call the updatePanel method
    }
}