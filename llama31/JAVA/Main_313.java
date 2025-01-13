import java.lang.String;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Main_313 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard Shortcuts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (java.lang.reflect.Field field : KeyEvent.class.getDeclaredFields()) {
            if (field.getName().startsWith("VK_")) {
                try {
                    model.addElement(field.getName().substring(3)); // remove "VK_" prefix
                } catch (Exception e) {
                    // ignore
                }
            }
        }

        JComboBox<String> keysLST = new JComboBox<>(model);
        frame.getContentPane().add(keysLST);

        frame.pack();
        frame.setVisible(true);
    }
}