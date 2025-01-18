import javax.swing.*;

public class DynamicPanelUpdater extends JFrame {
    {
        // Assuming you have a JFrame as your top-level container
        // Find the JPanel named "myDynamicPanel" in the content pane
        JPanel myDynamicPanel = null;
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JPanel && "myDynamicPanel".equals(component.getName())) {
                myDynamicPanel = (JPanel) component;
                break;
            }
        }
        // If not found, create it and add it to the content pane
        if (myDynamicPanel == null) {
            myDynamicPanel = new JPanel();
            myDynamicPanel.setName("myDynamicPanel");
            getContentPane().add(myDynamicPanel);
        }
        // Add a button to the panel dynamically at runtime
        myDynamicPanel.add(new JButton("Dynamic Button"));
        
        // Set up the frame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new DynamicPanelUpdater();
    }
}