/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.ui.Composite
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.Widget
 */
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MyComponent
extends Composite {
    private Label label = new Label("Hello World!");

    public MyComponent() {
        this.initWidget((Widget)this.label);
    }

    public static void main(String[] stringArray) {
    }
}
