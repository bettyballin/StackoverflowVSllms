import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.text.MessageFormat;

public class ShortcutHintLabel {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    int modifierKey = toolkit.getMenuShortcutKeyMask();
    String modifierKeyName = modifierKey == KeyEvent.META_MASK ? "\u2318" : "Ctrl";

    JLabel label = new JLabel(MessageFormat.format("With {0} you can select multiple items", modifierKeyName));

    public static void main(String[] args) {
        new ShortcutHintLabel();
    }
}