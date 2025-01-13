import javax.swing.*;
import java.awt.*;

public class JavaVersion {
    private JFrame frame;

    public JavaVersion() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // You can use a custom background renderer here
                // For simplicity, I'll just fill the background with a color
                g.setColor(Color.decode("#CCCCCC")); // A grayish color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JavaVersion javaVersion = new JavaVersion();
                javaVersion.frame.setVisible(true);
            }
        });
    }
}