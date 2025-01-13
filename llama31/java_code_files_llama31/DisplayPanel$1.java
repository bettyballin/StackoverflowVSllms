/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DisplayPanel.1
implements ActionListener {
    final /* synthetic */ DataModel val$dataModel;

    DisplayPanel.1() {
        this.val$dataModel = dataModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.val$dataModel.setTextFieldContent(DisplayPanel.this.textField.getText());
    }
}
