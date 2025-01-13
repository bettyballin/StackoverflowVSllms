import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FooComboBoxListener {
    public FooComboBoxListener() {
        // Assuming fooCombo is a JComboBox
        // You need to define or import fooCombo
        javax.swing.JComboBox fooCombo = new javax.swing.JComboBox();

        fooCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent arg0) {
                if (arg0.getStateChange() == ItemEvent.DESELECTED) {
                    // Get the deselected item
                    Object deselectedItem = arg0.getItem();
                    // Update your model accordingly
                } else if (arg0.getStateChange() == ItemEvent.SELECTED) {
                    // Get the selected item
                    Object selectedItem = arg0.getItem();
                    // Update your model accordingly
                }
            }
        });
    }

    public static void main(String[] args) {
        new FooComboBoxListener();
    }
}