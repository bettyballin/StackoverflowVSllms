import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class FormattedComboBox {
    public static void main(String[] args) {
        // Create a JComboBox with a JFormattedTextField as its editor
        JComboBox comboBox = new JComboBox(new Object[] {"1", "2", "3", "4", "5"});
        comboBox.setEditable(true);

        JTextComponent editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
        JFormattedTextField formattedEditor = new JFormattedTextField(new Integer(0));
        comboBox.setEditor(new DefaultCellEditor(formattedEditor));

        // Set up the formatting and validation
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(100);

        DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
        formattedEditor.setFormatterFactory(factory);

        // Create and show the GUI
        JFrame frame = new JFrame("Formatted JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(comboBox);
        frame.pack();
        frame.setVisible(true);
    }
}