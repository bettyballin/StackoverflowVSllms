import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Color;

public class MyPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        FontMetrics metrics = g.getFontMetrics();
        String label = "75 of 100 (75%)";
        int width = metrics.stringWidth(label); // calculate the bounding box based on font and string value
        int height = metrics.getHeight() - 1;

        Rectangle bounds = new Rectangle(getWidth(), getHeight()); // assuming bounds is the size of the panel
        g.setColor(Color.BLACK); // set the color for drawing text

        g.drawString(label, bounds.width / 2 - width / 2, bounds.height / 2 + height); // center align this text at middle of bar
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Center Aligned Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        MyPanel panel = new MyPanel();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}