/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTree;

public class MachineConfigurator {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("Machine Configurator");
        jFrame.setDefaultCloseOperation(3);
        JTree jTree = new JTree();
        jTree.setRootVisible(true);
        jFrame.add((Component)jTree, "Center");
        JTextPane jTextPane = new JTextPane();
        jFrame.add((Component)jTextPane, "Last");
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
