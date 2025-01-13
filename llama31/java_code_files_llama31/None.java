/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class None
extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(this.getBackground());
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(400, 300);
        jFrame.add(new None());
        jFrame.setVisible(true);
    }
}
