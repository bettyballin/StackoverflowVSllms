import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class FileChooserActionListener implements ActionListener {
    private JButton button;
    private JFileChooser chooser;
    private JTextField text;
    private JEditorPane pane;

    public FileChooserActionListener() {
        button = new JButton("Open");
        chooser = new JFileChooser();
        text = new JTextField(30);
        pane = new JEditorPane();

        // Add this class as the button's action listener
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int returnVal = 0;
        if (event.getSource() == button) {
            returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                text.setText(file.getAbsolutePath()); // Use the absolute path
                if (file != null) {
                    try {
                        pane.setPage(file.toURI().toURL()); // Convert to URL correctly
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Couldn't find this HTML file.");
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the class
        FileChooserActionListener listener = new FileChooserActionListener();

        // Set up GUI components and show the GUI
        JFrame frame = new JFrame("File Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the layout and add components
        JPanel panel = new JPanel();
        panel.add(listener.button);
        panel.add(listener.text);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}