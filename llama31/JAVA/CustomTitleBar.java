import javax.swing.*;
import java.awt.*;

public class CustomTitleBar extends JFrame {
    public CustomTitleBar() {
        super("Custom Title Bar");
        setLayout(new BorderLayout());

        // Create a custom root pane
        JRootPane rootPane = new JRootPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the additional button
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = 20;
                int height = 20;
                int x = getWidth() - width - 10;
                int y = 10;

                g2d.setColor(Color.WHITE);
                g2d.fillRect(x, y, width, height);

                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, width, height);
            }
        };

        // Set the custom root pane
        setRootPane(rootPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomTitleBar frame = new CustomTitleBar();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}