import java.lang.String;
import java.lang.reflect.Field;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class KeyEventModelLoader {
    DefaultComboBoxModel model;
    JComboBox keysLST;

    public KeyEventModelLoader() {
        model = new DefaultComboBoxModel();
        keysLST = new JComboBox();
        Field[] declaredFields = KeyEvent.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!field.getName().startsWith("VK_")) continue;
            try {
                String name = field.get(null).toString(); // Use null when the field is static.
                model.addElement(name);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        keysLST.setModel(model);
    }

    public static void main(String[] args) {
    }
}