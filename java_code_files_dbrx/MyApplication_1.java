import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyApplication {

    public static void main(String[] args) {
        JButton button = new JButton("Execute Python");
        button.addActionListener(e -> {
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    ProcessBuilder pb = new ProcessBuilder(); // set command, args etc. here
                    // Example: pb.command("python", "script.py");
                    Process p = pb.start();
                    int result = p.waitFor(); // blocks until process is finished
                    if (result != 0) { // success exit status depends on the executed program
                        SwingUtilities.invokeLater(() -> showError("Python script failed with code " + result));
                    } else {
                        SwingUtilities.invokeLater(Applet::loadFiles); // assuming Applet class has a static loadFiles method that loads files into applet
                    }
                    return null;
                }
            };
            worker.execute(); // start process in background
        });

        JFrame frame = new JFrame("My Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }
    
    // Define the showError method
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Assuming Applet class has a static loadFiles method
    public static class Applet {
        public static void loadFiles() {
            // Implement loadFiles method
            System.out.println("Files loaded into applet.");
        }
    }
}