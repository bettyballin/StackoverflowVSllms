/*
 * Decompiled with CFR 0.152.
 */
import java.util.Observable;
import java.util.Observer;

public class NodeObserver
implements Observer {
    @Override
    public void update(Observable observable, Object object) {
        if (object instanceof Node) {
            Node node = (Node)object;
            View view = this.createView(node);
            Controller controller = this.createController(node);
        }
    }

    private View createView(Node node) {
        return new View(node);
    }

    private Controller createController(Node node) {
        return new Controller(node);
    }

    public static void main(String[] stringArray) {
        NodeObserver nodeObserver = new NodeObserver();
        Observable observable = new Observable(){

            @Override
            public void notifyObservers(Object object) {
                super.notifyObservers(object);
            }
        };
        observable.addObserver(nodeObserver);
        observable.notifyObservers(new Node());
    }
}
