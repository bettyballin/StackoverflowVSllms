/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DisplayPanel
extends JPanel {
    private JTextField textField;
    private DataModel dataModel;

    public DisplayPanel(final DataModel dataModel) {
        this.dataModel = dataModel;
        this.textField = new JTextField(20);
        this.add(this.textField);
        this.textField.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dataModel.setTextFieldContent(DisplayPanel.this.textField.getText());
            }
        });
    }
}
