import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String shortcutSymbol = null;
        String systemShortcutName = null;

        if (System.getProperty("os.name").startsWith("Mac")) {
            systemShortcutName = "⌘"; // Mac specific command key symbol
        } else if (System.getProperty("mrj.version") != null) {
            systemShortcutName = "COMMAND";
        } else {
            System.out.println("Ctrl or Win");
            systemShortcutName = "CTRL";
        }

        Icon commandKeyFontIcon = null; // Assume this is defined elsewhere
        JLabel cmdKeyLbl = new JLabel(systemShortcutName, commandKeyFontIcon, javax.swing.SwingConstants.CENTER);
    }
}