/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class CompositeView
extends View {
    private List<View> childViews = new ArrayList<View>();

    public void addChild(Node node) {
        View view = this.createView(node);
        Controller controller = this.createController(node);
        this.childViews.add(view);
    }

    private View createView(Node node) {
        return new View();
    }

    private Controller createController(Node node) {
        return new Controller();
    }

    public static void main(String[] stringArray) {
        CompositeView compositeView = new CompositeView();
        Node node = new Node();
        compositeView.addChild(node);
    }
}
