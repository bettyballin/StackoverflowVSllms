import javax.swing.*;
import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.text.NumberFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JFormattedTextField;

public class Main_16 {
    public static void main(String[] args) {
        JComboBox comboBox = new JComboBox(new Object[]{"", "10", "20", "30", "40"});
        
        // Make the combo box editable
        comboBox.setEditable(true);
        
        // Set up a formatter for numbers in the range 0 to 100
        NumberFormat format = NumberFormat.getNumberInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(100);
        formatter.setAllowsInvalid(false); // Prevents invalid entries
        
        // Create a JFormattedTextField with the formatter
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setFormatterFactory(new DefaultFormatterFactory(formatter));
        
        // Set the JFormattedTextField as the editor component for the combo box
        comboBox.setEditor(new BasicComboBoxEditor() {
            @Override
            public Component getEditorComponent() {
                return formattedTextField;
            }
        });
        
        JFrame frame = new JFrame();
        frame.add(comboBox);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}