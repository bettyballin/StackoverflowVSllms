import javax.swing.SwingWorker;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class ImageLoaderWorker {

    JScrollPane scroll;

    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
        @Override
        protected Void doInBackground() throws Exception {
            // Load your images here...
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
                scroll.getVerticalScrollBar().setValue(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    };

    public static void main(String[] args) {
    }
}