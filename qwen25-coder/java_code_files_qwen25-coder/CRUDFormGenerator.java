import java.lang.String;
import javax.swing.*;
import java.awt.*;

public class CRUDFormGenerator {
    public static void generateForm(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(0, 2));

        // Example: Adding fields programmatically
        String[] fieldNames = {"Name", "Email", "Phone"};
        for (String fieldName : fieldNames) {
            panel.add(new JLabel(fieldName));
            panel.add(new JTextField());
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CRUD Form");
        generateForm(frame);
        frame.setVisible(true);
    }
}