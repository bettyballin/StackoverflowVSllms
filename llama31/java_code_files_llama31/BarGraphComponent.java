/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BarGraphComponent
extends JComponent {
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color BAR_GRAPH_COLOR = Color.BLUE;
    private static final Color BORDER_COLOR = Color.BLACK;
    private int actual;
    private int expected;

    public BarGraphComponent(int n, int n2) {
        this.actual = n;
        this.expected = n2;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        double d = this.expected == 0 ? 0.0 : (double)this.actual / (double)this.expected;
        Rectangle rectangle = super.getBounds();
        graphics.setColor(BACKGROUND);
        graphics.fillRect(0, 0, rectangle.width, rectangle.height);
        graphics.setColor(BAR_GRAPH_COLOR);
        graphics.fillRect(0, 0, (int)((double)rectangle.width * d), rectangle.height);
        graphics.setColor(BORDER_COLOR);
        graphics.drawRect(0, 0, rectangle.width - 1, rectangle.height - 1);
    }

    public static void main(String[] stringArray) {
        SwingUtilities.invokeLater(() -> {
            JFrame jFrame = new JFrame();
            jFrame.setDefaultCloseOperation(3);
            jFrame.add(new BarGraphComponent(50, 100));
            jFrame.setSize(200, 200);
            jFrame.setVisible(true);
        });
    }
}
