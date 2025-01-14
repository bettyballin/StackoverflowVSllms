import java.lang.String;
import javax.swing.*;
import java.awt.*;

public class BatchRendering extends JPanel {
    private Shape[] shapes = new Shape[1000]; // Example array of shapes

    public BatchRendering() {
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = new Rectangle(i * 5, i * 5, 40, 40); // Simple example shapes
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;
            
            // Begin batch rendering operation
            for (Shape shape : shapes) {
                g2d.draw(shape); // Draw all shapes in one go to reduce overhead
            }
            // End batch rendering operation
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Batch Rendering Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new BatchRendering());
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}