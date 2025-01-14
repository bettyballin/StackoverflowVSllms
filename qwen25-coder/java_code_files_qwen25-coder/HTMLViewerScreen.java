import javax.swing.*;

public class HTMLViewerScreen extends JFrame {
    public HTMLViewerScreen() {
        // Create the JEditorPane instance
        JEditorPane myEditorPane = new JEditorPane();
        myEditorPane.setContentType("text/html");
        myEditorPane.setText("<html><body><h1>Hello, World!</h1></body></html>");
        myEditorPane.setEditable(false);

        // Add the JEditorPane to this frame's content pane
        add(new JScrollPane(myEditorPane));

        // Set frame properties
        setTitle("HTML Viewer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HTMLViewerScreen viewer = new HTMLViewerScreen();
            viewer.setVisible(true);
        });
    }
}