import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Model class holding data
class DataModel {
    private String text = "";
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void setText(String text) {
        this.text = text;
        notifyObservers();
    }

    public String getText() {
        return text;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

// Observer interface
interface Observer {
    void update(DataModel model);
}

// Display JPanel observing changes in the data model
class DisplayPanel extends JPanel implements Observer {
    private JTextField textField;

    public DisplayPanel(DataModel model) {
        super(new FlowLayout());
        textField = new JTextField(20);
        add(textField);

        // Register as observer to get notified of changes in the model
        model.addObserver(this);
    }

    @Override
    public void update(DataModel model) {
        textField.setText(model.getText());
    }

    public void setText(String text) {
        textField.setText(text);
    }
}

// Control JPanel that manipulates the data model's content
class ControlPanel extends JPanel implements Observer {
    private JButton openfile;
    private DataModel model;

    public ControlPanel(DataModel model) {
        super(new FlowLayout());
        this.model = model;
        openfile = new JButton("Convert file");
        add(openfile);

        // Listener to update the model on button press
        openfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newValue = JOptionPane.showInputDialog(null, "Enter text:");
                if (newValue != null) {
                    model.setText(newValue);
                }
            }
        });
    }

    @Override
    public void update(DataModel model) {
        // Update any UI elements in this panel that depend on the model state
    }
}

// Main frame containing both panels
public class JPanelsExample extends JFrame {
    public JPanelsExample() {
        setTitle("JPanel Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the data model and panels
        DataModel model = new DataModel();
        DisplayPanel displayPanel = new DisplayPanel(model);
        ControlPanel controlPanel = new ControlPanel(model);

        add(displayPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JPanelsExample();
            frame.setVisible(true);
        });
    }
}