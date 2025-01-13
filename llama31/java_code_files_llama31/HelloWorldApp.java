/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldApp
extends JFrame {
    public HelloWorldApp() {
        this.initComponents();
    }

    private void initComponents() {
        JLabel jLabel = new JLabel("Hello, World!");
        this.add((Component)jLabel, "Center");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(3);
    }

    public static void main(String[] stringArray) {
        new HelloWorldApp().setVisible(true);
    }
}
