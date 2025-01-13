/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFromByteArray {
    public static void main(String[] stringArray) {
        byte[] byArray = new byte[]{};
        String string = Base64.getEncoder().encodeToString(byArray);
        String string2 = "data:image/png;base64," + string;
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(3);
        ImageIcon imageIcon = new ImageIcon(string2);
        JLabel jLabel = new JLabel(imageIcon);
        jFrame.getContentPane().add(jLabel);
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
    }
}
