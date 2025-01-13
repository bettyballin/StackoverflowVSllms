/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class DateFieldFrame {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(3);
        JFormattedTextField jFormattedTextField = new JFormattedTextField(DateFormat.getDateInstance());
        jFrame.getContentPane().add(jFormattedTextField);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
