/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyApp_3 {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("MyApp");
        jFrame.setDefaultCloseOperation(3);
        JPanel jPanel = new JPanel();
        jFrame.getContentPane().add(jPanel);
        JButton jButton = new JButton("Click me!");
        jButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Button clicked!");
            }
        });
        jPanel.add(jButton);
        jFrame.setSize(300, 200);
        jFrame.setVisible(true);
    }
}
