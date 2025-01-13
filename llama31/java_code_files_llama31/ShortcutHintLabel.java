/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Toolkit;
import java.text.MessageFormat;
import javax.swing.JLabel;

public class ShortcutHintLabel {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    int modifierKey = this.toolkit.getMenuShortcutKeyMask();
    String modifierKeyName = this.modifierKey == 4 ? "\u2318" : "Ctrl";
    JLabel label = new JLabel(MessageFormat.format("With {0} you can select multiple items", this.modifierKeyName));

    public static void main(String[] stringArray) {
        new ShortcutHintLabel();
    }
}
