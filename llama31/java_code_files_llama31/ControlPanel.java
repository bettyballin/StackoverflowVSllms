/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class ControlPanel
extends JPanel {
    private DataModel dataModel;

    public ControlPanel(final DataModel dataModel) {
        this.dataModel = dataModel;
        JButton jButton = new JButton("Convert file");
        jButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String string = dataModel.getTextFieldContent();
                System.out.println("Text field content: " + string);
            }
        });
        this.add(jButton);
    }
}
