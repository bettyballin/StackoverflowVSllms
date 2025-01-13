/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JPanel;

public class PanelUpdater {
    private static JPanel dynamicPanel = new JPanel();

    public static void updatePanel() {
        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }

    public static void main(String[] stringArray) {
        PanelUpdater.updatePanel();
    }
}
