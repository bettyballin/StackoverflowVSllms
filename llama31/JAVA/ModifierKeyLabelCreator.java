import java.awt.Label;
import java.awt.event.KeyEvent;
import java.text.MessageFormat;
import javax.swing.JLabel;

public class ModifierKeyLabelCreator {
    int modifierKey = KeyEvent.getMenuShortcutKeyMask();
    String modifierKeyName = modifierKey == KeyEvent.META_MASK ? "\u2318" : "Ctrl";

    JLabel label = new JLabel(MessageFormat.format("With {0} you can select multiple items", modifierKeyName));

    public static void main(String[] args) {
        new ModifierKeyLabelCreator();
    }
}