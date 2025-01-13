/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataPanel {
    private JTextField field1;
    private JTextField field2;

    public DataPanel() {
        JPanel jPanel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(jPanel);
        jPanel.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        this.field1 = new JTextField();
        this.field2 = new JTextField();
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup().addComponent(this.field1).addComponent(this.field2)));
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(this.field1).addComponent(this.field2));
        this.field1.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                DataPanel.this.validateField1();
            }
        });
        this.field2.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                DataPanel.this.validateField2();
            }
        });
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(3);
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void validateField1() {
        String string = this.field1.getText();
        if (!this.isValid(string)) {
            this.field1.setBackground(Color.RED);
        } else {
            this.field1.setBackground(Color.WHITE);
        }
    }

    private void validateField2() {
    }

    private boolean isValid(String string) {
        return true;
    }

    public static void main(String[] stringArray) {
        new DataPanel();
    }
}
