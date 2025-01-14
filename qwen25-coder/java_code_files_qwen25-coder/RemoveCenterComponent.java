import java.lang.String;
import javax.swing.*;
import java.awt.*;

public class RemoveCenterComponent {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new BorderLayout());

        // Adding a button to the center
        JButton originalButton = new JButton("Click Me");
        panel.add(originalButton, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);

        // To "remove" the component from the CENTER without referencing it directly:
        // Add a filler to the CENTER position
        panel.add(new JPanel(), BorderLayout.CENTER);
    }
}