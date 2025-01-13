import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class ProcessRunner_1_1 {
    // Create a new thread to run the process
    Thread processThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // Create the ProcessBuilder and start the process
                ProcessBuilder pb = new ProcessBuilder("python", "your_script.py");
                Process p = pb.start();

                // Wait for the process to finish
                p.waitFor();

                // Load the files into the applet
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Code to load files into applet goes here
                    }
                });
            } catch (Exception e) {
                // Handle any exceptions that occur
            }
        }
    });

    public ProcessRunner_1() {
        // Create a button and add an action listener
        javax.swing.JButton yourButton = new javax.swing.JButton("Run Process");
        yourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processThread.start();
            }
        });

        // Create a JFrame and add the button
        javax.swing.JFrame frame = new javax.swing.JFrame("Process Runner");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(yourButton);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProcessRunner_1();
    }
}