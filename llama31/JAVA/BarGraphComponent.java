import java.awt.Graphics;
import java.awt.Rectangle;

public class BarGraphComponent extends javax.swing.JComponent {
    private static final java.awt.Color BACKGROUND = java.awt.Color.WHITE;
    private static final java.awt.Color BAR_GRAPH_COLOR = java.awt.Color.BLUE;
    private static final java.awt.Color BORDER_COLOR = java.awt.Color.BLACK;

    private int actual;
    private int expected;

    public BarGraphComponent(int actual, int expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double proportion = (expected == 0) ? 0 : ((double) actual) / expected;
        Rectangle bounds = super.getBounds();

        g.setColor(BACKGROUND);
        g.fillRect(0, 0, bounds.width, bounds.height);

        g.setColor(BAR_GRAPH_COLOR);
        g.fillRect(0, 0, (int) (bounds.width * proportion), bounds.height);

        g.setColor(BORDER_COLOR);
        g.drawRect(0, 0, bounds.width - 1, bounds.height - 1);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame();
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.add(new BarGraphComponent(50, 100));
            frame.setSize(200, 200);
            frame.setVisible(true);
        });
    }
}