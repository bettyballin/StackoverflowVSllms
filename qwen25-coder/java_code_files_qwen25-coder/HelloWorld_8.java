import javax.swing.*;
import java.awt.*;

public class HelloWorld {

    public static void main(String[] args) {
        // Create and display the application window
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HelloWorldFrame();
            }
        });
    }
}

class HelloWorldFrame extends JFrame {

    public HelloWorldFrame() {
        // Set the frame properties
        setTitle("HelloWorld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 240);
        setLocationRelativeTo(null); // Center the window

        // Set layout manager
        setLayout(new BorderLayout());

        // Add the custom component
        HelloField helloField = new HelloField();
        add(helloField, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }
}

class HelloField extends JPanel {

    public HelloField() {
        // Set preferred size if needed
        // setPreferredSize(new Dimension(320, 240));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Display a simple message in the center of the screen.
        String text = "Hello World!";
        g.setColor(Color.BLACK);

        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2;

        g.drawString(text, x, y);
    }
}