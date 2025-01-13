import javax.swing.JPanel;
import javax.swing.JFrame;

public class ComponentAccessor {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel dynamicPanel = new JPanel();
        dynamicPanel.setName("dynamicPanel");
        frame.getContentPane().add(dynamicPanel);
        
        // Access the dynamicPanel
        JPanel accessedPanel = (JPanel) frame.getContentPane().getComponents()[0];
        if (accessedPanel.getName().equals("dynamicPanel")) {
            System.out.println("Accessed the dynamicPanel");
        }
    }
}