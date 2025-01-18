import javax.swing.*;
import java.awt.event.*;

public class FooComboExample {

    private JComboBox<Foo> fooCombo;
    private DefaultComboBoxModel<Foo> fooModel;

    public FooComboExample() {
        // Initialize fooModel and fooCombo
        fooModel = new DefaultComboBoxModel<>();
        fooCombo = new JComboBox<>(fooModel);

        // Add some items to fooModel
        fooModel.addElement(new Foo("Item 1"));
        fooModel.addElement(new Foo("Item 2"));
        fooModel.addElement(new Foo("Item 3"));

        // The provided code starts here
        fooCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent arg0) {
                if (arg0.getStateChange() == ItemEvent.SELECTED){
                    fooChangedHandler((Foo) fooModel.getSelectedItem());  // new selected value
                } else{
                     // do your thing when an item is deselected, e.g.:
                   Foo oldValue = (Foo) arg0.getItem();   // old selected value
                   // ...
                }
            }
        });
        // The provided code ends here
    }

    private void fooChangedHandler(Foo newValue) {
        System.out.println("Selected: " + newValue);
    }

    // Define Foo class
    static class Foo {
        private String name;

        public Foo(String name) {
            this.name = name;
        }

        public String toString() { return name; }
    }

    public static void main(String[] args) {
        // Run the example
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FooComboExample example = new FooComboExample();
                JFrame frame = new JFrame("FooCombo Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(example.fooCombo);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}