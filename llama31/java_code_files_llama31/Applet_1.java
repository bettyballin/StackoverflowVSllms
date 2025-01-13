/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JApplet;

public class Applet_1
extends JApplet {
    @Override
    public void init() {
        MyModel myModel = new MyModel();
        MyView myView = new MyView();
        MyController myController = new MyController(myModel, myView);
        myModel.setText("Hello World!");
    }

    public static void main(String[] stringArray) {
    }
}
