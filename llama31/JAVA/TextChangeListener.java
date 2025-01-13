import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;

public class TextChangeListener {
    private static Object text; // Assuming text is an object with addPropertyChangeListener method
    private static Object scroll; // Assuming scroll is an object with getVerticalScrollBar method

    public static void main(String[] args) {
        text = new javax.swing.JTextArea(); // Initialize text object
        scroll = new javax.swing.JScrollPane(); // Initialize scroll object

        ((javax.swing.JTextArea) text).addPropertyChangeListener("document", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getNewValue() == null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            ((javax.swing.JScrollPane) scroll).getVerticalScrollBar().setValue(0);
                        }
                    });
                }
            }
        });
    }
}