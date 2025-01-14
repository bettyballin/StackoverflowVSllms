import java.lang.String;
// Importing libraries needed
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstApp {
    public static void main(String[] args) {
        // Creating instance of JFrame 
        JFrame frame = new JFrame("My First App");

        // Creates a label with text "Hello, World!".
        JLabel label = new JLabel("Hello, World!");

        // Add the label to the frame's content pane
        frame.getContentPane().add(label);

        // Set dimensions and position of the window
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centers the window

        // Enable close functionality
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);
    }
}