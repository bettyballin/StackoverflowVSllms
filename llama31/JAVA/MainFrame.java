import java.lang.String;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Shared data model
class DataModel {
    private String textFieldContent;

    public void setTextFieldContent(String content) {
        this.textFieldContent = content;
    }

    public String getTextFieldContent() {
        return textFieldContent;
    }
}

// Display panel with JTextField
class DisplayPanel extends JPanel {
    private JTextField textField;
    private DataModel dataModel;

    public DisplayPanel(DataModel dataModel) {
        this.dataModel = dataModel;
        textField = new JTextField(20);
        add(textField);

        // Update data model when text field changes
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataModel.setTextFieldContent(textField.getText());
            }
        });
    }
}

// Control panel with buttons
class ControlPanel extends JPanel {
    private DataModel dataModel;

    public ControlPanel(DataModel dataModel) {
        this.dataModel = dataModel;
        JButton openFileButton = new JButton("Convert file");

        // Access data model when button is pressed
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFieldContent = dataModel.getTextFieldContent();
                // Perform action with text field content
                System.out.println("Text field content: " + textFieldContent);
            }
        });
        add(openFileButton);
    }
}

// Main JFrame
public class MainFrame extends JFrame {
    public MainFrame() {
        DataModel dataModel = new DataModel();
        DisplayPanel displayPanel = new DisplayPanel(dataModel);
        ControlPanel controlPanel = new ControlPanel(dataModel);

        add(displayPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}