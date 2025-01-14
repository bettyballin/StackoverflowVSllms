import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Model class
class MyModel {
    private String text = "Initial Text";

    // Utility to manage PropertyChangeListeners
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setText(String text) {
        String oldText = this.text;
        this.text = text;
        propertyChangeSupport.firePropertyChange("text", oldText, this.text);
    }

    public String getText() {
        return text;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}

public class MyView extends JFrame implements PropertyChangeListener {
    private JLabel label;

    public MyView(MyModel model) {
        // GUI setup
        label = new JLabel(model.getText());

        // Bind the model to this view
        model.addPropertyChangeListener(this);

        // Adding components and finishing settings up
        getContentPane().add(label);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("text".equals(evt.getPropertyName())) {
            label.setText((String)evt.getNewValue());
        }
    }

    public static void main(String[] args) {
        final MyModel model = new MyModel();
        MyView view = new MyView(model);
        
        // Simulate a change in data model
        Timer timer = new Timer(1000, e -> model.setText("Updated Text from Timer"));
        timer.start();
    }
}