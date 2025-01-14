import java.lang.String;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.*;

public class ExternalProcessRunner extends JFrame {

    public ExternalProcessRunner() {
        JButton button = new JButton("Run Python Script");
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runExternalScript();
            }
        });
    }

    private void runExternalScript() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Void> task = () -> {
            ProcessBuilder pb = new ProcessBuilder("python", "your_script.py");
            try {
                Process p = pb.start();
                int exitCode = p.waitFor();
                if (exitCode == 0) {
                    // Assuming the files are generated successfully, load them into applet
                    SwingUtilities.invokeLater(() -> {
                        System.out.println("Script finished and files loaded.");
                        // Code to load files into an applet would go here.
                    });
                } else {
                    System.err.println("Script exited with error code: " + exitCode);
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
            return null;
        };

        executor.submit(task);
        executor.shutdown(); // Shutdown is called but doesn't affect running tasks
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExternalProcessRunner frame = new ExternalProcessRunner();
            frame.setVisible(true);
        });
    }
}