import javax.swing.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class KeySelector {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Key Selector");
            JComboBox<String> keysLST = new JComboBox<>();

            // Populate the combo box with available alphabetic keys
            List<String> keyNames = getAlphabeticKeys();
            keysLST.setModel(new DefaultComboBoxModel<>(keyNames.toArray(new String[0])));

            frame.add(keysLST);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static List<String> getAlphabeticKeys() {
        List<String> keyNames = new ArrayList<>();
        Field[] fields = KeyEvent.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().startsWith("VK_") && field.getName().length() == 4) { // Only alphabetic keys have 4-character names like VK_A
                try {
                    int keyCode = field.getInt(null);
                    char keyChar = KeyEvent.getKeyText(keyCode).charAt(0); // Translate the keycode to character
                    if (Character.isLetter(keyChar)) { // Check if it is a letter
                        keyNames.add(Character.toString(keyChar));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return keyNames;
    }
}