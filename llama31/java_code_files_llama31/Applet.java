/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Applet
extends Canvas {
    private JSObject jsObject = new JSObject();

    @Override
    public void paint(Graphics graphics) {
    }

    public void updateData(String string) {
        System.out.println(string);
    }

    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("Applet");
        jFrame.setSize(400, 400);
        jFrame.add(new Applet());
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
    }
}
