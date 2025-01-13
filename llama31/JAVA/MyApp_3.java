import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple Swing application
 */
public class MyApp_3 {

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("MyApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to add components
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        // Create a button
        JButton button = new JButton("Click me!");
        // Add event handler
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle button click
                System.out.println("Button clicked!");
            }
        });
        // Add button to panel
        panel.add(button);

        // Set frame size and make it visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}