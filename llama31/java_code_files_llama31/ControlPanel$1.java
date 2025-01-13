/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControlPanel.1
implements ActionListener {
    final /* synthetic */ DataModel val$dataModel;

    ControlPanel.1() {
        this.val$dataModel = dataModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = this.val$dataModel.getTextFieldContent();
        System.out.println("Text field content: " + string);
    }
}
