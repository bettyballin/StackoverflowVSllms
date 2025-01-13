/*
 * Decompiled with CFR 0.152.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class CustomTitleBar
extends JFrame {
    public CustomTitleBar() {
        super("Custom Title Bar");
        this.setLayout(new BorderLayout());
        JRootPane jRootPane = new JRootPane(){

            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int n = 20;
                int n2 = 20;
                int n3 = this.getWidth() - n - 10;
                int n4 = 10;
                graphics2D.setColor(Color.WHITE);
                graphics2D.fillRect(n3, n4, n, n2);
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawRect(n3, n4, n, n2);
            }
        };
        this.setRootPane(jRootPane);
    }

    public static void main(String[] stringArray) {
        SwingUtilities.invokeLater(() -> {
            CustomTitleBar customTitleBar = new CustomTitleBar();
            customTitleBar.setDefaultCloseOperation(3);
            customTitleBar.setSize(400, 300);
            customTitleBar.setVisible(true);
        });
    }
}
