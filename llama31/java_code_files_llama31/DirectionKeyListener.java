/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DirectionKeyListener
implements KeyListener {
    private JPanel panel = new JPanel();

    public DirectionKeyListener() {
        this.panel.addKeyListener(this);
        JFrame jFrame = new JFrame();
        jFrame.add(this.panel);
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        this.panel.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    public static void main(String[] stringArray) {
        new DirectionKeyListener();
    }
}
