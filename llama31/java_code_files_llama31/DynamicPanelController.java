/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JButton;
import javax.swing.JPanel;

public class DynamicPanelController {
    public static void main(String[] stringArray) {
        DynamicPanelController dynamicPanelController = new DynamicPanelController();
    }

    public DynamicPanelController() {
        JButton jButton = new JButton("Click me!");
        JPanel jPanel = new JPanel();
        jPanel.add(jButton);
    }
}
