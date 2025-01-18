import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

public class YourApplet extends JApplet {
    private void triggerSwingAction(JComponent target, String actionCommand) {
        EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        ActionEvent event = new ActionEvent(target, ActionEvent.ACTION_PERFORMED, actionCommand);

        javax.swing.SwingUtilities.invokeLater(() -> queue.postEvent(event));
    }

    public static void main(String[] args) {
    }
}