/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main_650 {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("Action Invocation");
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        final AbstractAction abstractAction = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Action Performed!");
            }
        };
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                abstractAction.actionPerformed(new ActionEvent(this, 1001, null));
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}
