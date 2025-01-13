/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import java.awt.Container;
import javax.swing.JPanel;

public class PanelFinder {
    private JPanel dynamicPanel;

    public PanelFinder() {
        for (Component component : this.getContentPane().getComponents()) {
            if (!(component instanceof JPanel) || !component.getName().equals("dynamicPanel")) continue;
            this.dynamicPanel = (JPanel)component;
            break;
        }
    }

    public JPanel getDynamicPanel() {
        return this.dynamicPanel;
    }

    public static void main(String[] stringArray) {
        PanelFinder panelFinder = new PanelFinder();
    }

    public Container getContentPane() {
        return null;
    }
}
