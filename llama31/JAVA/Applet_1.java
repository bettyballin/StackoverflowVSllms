import java.lang.String;
import javax.swing.JLabel;
import javax.swing.JApplet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Model
class MyModel {
    private String text;
    private PropertyChangeSupport pcs;

    public MyModel() {
        pcs = new PropertyChangeSupport(this);
    }

    public void setText(String text) {
        String oldText = this.text;
        this.text = text;
        pcs.firePropertyChange("text", oldText, text);
    }

    public String getText() {
        return text;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}

// View
class MyView extends JApplet {
    private JLabel label;

    public MyView() {
        label = new JLabel();
        add(label);
    }

    public void updateText(String text) {
        label.setText(text);
    }
}

// Controller
class MyController {
    private MyModel model;
    private MyView view;

    public MyController(MyModel model, MyView view) {
        this.model = model;
        this.view = view;

        model.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("text")) {
                    view.updateText((String) e.getNewValue());
                }
            }
        });
    }
}

public class Applet_1 extends JApplet {
    @Override
    public void init() {
        MyModel model = new MyModel();
        MyView view = new MyView();
        MyController controller = new MyController(model, view);

        model.setText("Hello World!");
    }

	public static void main(String[] args) {
	}
}