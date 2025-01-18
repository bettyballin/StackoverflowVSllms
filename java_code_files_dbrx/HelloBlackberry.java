import javax.swing.*;

public class HelloBlackberry {
    public static void main(String[] args) {
        // Run the GUI code in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HelloBlackberry().createAndShowGUI();
            }
        });
    }

    public HelloBlackberry() {
        // Constructor can be left empty or used for initialization if needed
    }
    
    public void createAndShowGUI() {
        JFrame frame = new JFrame("HelloBlackBerry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello BlackBerry!", SwingConstants.CENTER);
        frame.getContentPane().add(label);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}