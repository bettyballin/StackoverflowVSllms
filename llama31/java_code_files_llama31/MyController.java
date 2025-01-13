/*
 * Decompiled with CFR 0.152.
 */
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class MyController {
    private MyModel model;
    private MyView view;

    public MyController(MyModel myModel, final MyView myView) {
        this.model = myModel;
        this.view = myView;
        myModel.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                if (propertyChangeEvent.getPropertyName().equals("text")) {
                    myView.updateText((String)propertyChangeEvent.getNewValue());
                }
            }
        });
    }
}
