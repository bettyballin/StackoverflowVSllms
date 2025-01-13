import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class None extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // VisualStyleRenderer is not available in Java, 
        // we can use the following code to draw a rectangle instead.
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new None());
        frame.setVisible(true);
    }
}