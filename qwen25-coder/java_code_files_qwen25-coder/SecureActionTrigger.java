import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class SecureActionTrigger {

    private JTextComponent textComponent;
    private Action action;

    public SecureActionTrigger(JTextComponent textComponent, Action action) {
        this.textComponent = textComponent;
        this.action = action;
    }

    public void triggerAction() {
        EventQueue.invokeLater(() -> action.actionPerformed(new ActionEvent(textComponent, ActionEvent.ACTION_PERFORMED, null)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Secure Action Trigger Example");
            JTextArea textArea = new JTextArea();

            // Assuming you have a paste action
            Action pasteAction = textArea.getActionMap().get(DefaultEditorKit.pasteAction);

            SecureActionTrigger trigger = new SecureActionTrigger(textArea, pasteAction);

            // Add popup menu with an item to trigger paste
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem menuItem = new JMenuItem("Paste");
            menuItem.addActionListener(e -> trigger.triggerAction());
            popupMenu.add(menuItem);

            textArea.setComponentPopupMenu(popupMenu);

            frame.getContentPane().add(new JScrollPane(textArea));
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}