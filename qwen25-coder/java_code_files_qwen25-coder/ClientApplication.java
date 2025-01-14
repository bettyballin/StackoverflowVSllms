import java.lang.String;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JFrame;

public class ClientApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI(); // Assume GUI is your main window
        });
    }

    public void performTaskOnServer() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Call server method here
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    // Handle result after the task is completed.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }
}

class GUI extends JFrame {
    public GUI() {
        // Minimal implementation to make the GUI visible
        setTitle("GUI Window");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}