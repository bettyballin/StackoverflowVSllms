/*
 * Decompiled with CFR 0.152.
 */
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyChecker
extends JFrame {
    JLabel keyLabel = new JLabel("Hit any key");

    public KeyChecker() {
        super("Hit a Key");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout(1));
        KeyMonitor keyMonitor = new KeyMonitor(this);
        this.setFocusable(true);
        this.addKeyListener(keyMonitor);
        this.add(this.keyLabel);
        this.setVisible(true);
    }

    public static void main(String[] stringArray) {
        new KeyChecker();
    }
}
