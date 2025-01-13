import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main_650 {
    public static void main(String[] args) {
        // Create a new JFrame for demonstration
        JFrame frame = new JFrame("Action Invocation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Assume 'action' is the Swing Action you want to invoke
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action Performed!");
                // You can add your action handling logic here
            }
        };

        // Create a Runnable that invokes the action
        Runnable invokeAction = new Runnable() {
            public void run() {
                action.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        };

        // Enqueue the Runnable to the EDT using invokeLater
        SwingUtilities.invokeLater(invokeAction);
    }
}