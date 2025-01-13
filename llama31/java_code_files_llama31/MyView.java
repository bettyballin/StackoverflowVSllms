/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JApplet;
import javax.swing.JLabel;

class MyView
extends JApplet {
    private JLabel label = new JLabel();

    public MyView() {
        this.add(this.label);
    }

    public void updateText(String string) {
        this.label.setText(string);
    }
}
