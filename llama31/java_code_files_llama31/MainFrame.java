/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import javax.swing.JFrame;

public class MainFrame
extends JFrame {
    public MainFrame() {
        DataModel dataModel = new DataModel();
        DisplayPanel displayPanel = new DisplayPanel(dataModel);
        ControlPanel controlPanel = new ControlPanel(dataModel);
        this.add((Component)displayPanel, "Center");
        this.add((Component)controlPanel, "South");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public static void main(String[] stringArray) {
        new MainFrame();
    }
}
