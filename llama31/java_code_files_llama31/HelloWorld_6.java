/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.EntryPoint
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.RootPanel
 *  com.google.gwt.user.client.ui.Widget
 */
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld_6
implements EntryPoint {
    public void onModuleLoad() {
        Label label = new Label("Hello, World!");
        RootPanel.get().add((Widget)label);
    }

    public static void main(String[] stringArray) {
    }
}
