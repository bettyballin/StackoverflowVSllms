import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

// Controller class for the view
public class MyViewController {
    private final MyView view;
    private final MyModel model;

    public MyViewController(MyView view, MyModel model) {
        this.view = view;
        this.model = model;
        
        // Add listeners to buttons and other controls
        view.addButtonClickListener(this::handleButtonClick);
        view.addTableSelectionListener(this::handleTableSelect);
    }

    private void handleButtonClick(ActionEvent e) {
        // Handle actions for the buttons
        switch (e.getActionCommand()) {
            case "save":
                model.saveData();
                break;
            case "delete":
                model.deleteData(view.getSelectedTableRow());
                break;
        }
    }

    private void handleTableSelect(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selected = view.getTable().getSelectedRow();
            // Do something with the selection
        }
    }
}

// View class responsible for UI components
class MyView {
    private JButton saveButton;
    private JButton deleteButton;
    private JTable table;

    public MyView() {
        // Initialize UI components
        saveButton = new JButton("Save");
        saveButton.setActionCommand("save");

        deleteButton = new JButton("Delete");
        deleteButton.setActionCommand("delete");

        table = new JTable();

        // Add components to a panel or frame
        JFrame frame = new JFrame("My Application");
        JPanel panel = new JPanel();
        panel.add(saveButton);
        panel.add(deleteButton);
        panel.add(new JScrollPane(table));
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public int getSelectedTableRow() {
        return table.getSelectedRow();
    }

    public JTable getTable() {
        return table;
    }

    // Methods to set listeners
    public void addButtonClickListener(ActionListener listener) {
        saveButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
    }

    public void addTableSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
}

// Model class handling data manipulation
class MyModel {
    // Data storage and operation methods
    public void saveData() {
        // Save logic here
    }

    public void deleteData(int row) {
        // Delete logic here
    }

    public static void main(String[] args) {
        // Initialize the model, view, and controller
        MyModel model = new MyModel();
        MyView view = new MyView();
        MyViewController controller = new MyViewController(view, model);
    }
}