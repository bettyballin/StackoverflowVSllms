import java.lang.String;
import javax.swing.*;
import java.awt.*;
public class RemoveComponentFromCenter {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Remove Component from Center");
        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        // Add component to the center.
        contentPane.add(new JButton("Example"), BorderLayout.CENTER);
        
        // Set up frame
        SwingUtilities.invokeLater(() -> {
            frame.pack();
            frame.setVisible(true);
        });

        Thread.sleep(2000);

        // Remove component from center by index (0).
        SwingUtilities.invokeLater(() -> {
            contentPane.remove(0);    // Index corresponds to position in the Container
            contentPane.revalidate();
            contentPane.repaint();
        });
    }
}