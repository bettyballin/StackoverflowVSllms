/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComponentAccessor {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        jPanel.setName("dynamicPanel");
        jFrame.getContentPane().add(jPanel);
        JPanel jPanel2 = (JPanel)jFrame.getContentPane().getComponents()[0];
        if (jPanel2.getName().equals("dynamicPanel")) {
            System.out.println("Accessed the dynamicPanel");
        }
    }
}
