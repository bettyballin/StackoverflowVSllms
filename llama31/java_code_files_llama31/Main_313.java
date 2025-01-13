/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Main_313 {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("Keyboard Shortcuts");
        jFrame.setDefaultCloseOperation(3);
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
        for (Field field : KeyEvent.class.getDeclaredFields()) {
            if (!field.getName().startsWith("VK_")) continue;
            try {
                defaultComboBoxModel.addElement(field.getName().substring(3));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        JComboBox jComboBox = new JComboBox(defaultComboBoxModel);
        jFrame.getContentPane().add(jComboBox);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
