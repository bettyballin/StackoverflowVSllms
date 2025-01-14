import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SimpleMidlet extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton exitButton;

    public SimpleMidlet() {
        super("Connectivity Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        panel.add(exitButton);

        // Attempt to connect
        try {
            URL url = new URL("http://example.com/service");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            JLabel status = new JLabel("Connected successfully!");
            panel.add(status);
        } catch (Exception e) {
            JLabel status = new JLabel("Failed to connect: " + e.getMessage());
            panel.add(status);
        }

        add(panel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            dispose(); // Close the frame
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SimpleMidlet();
    }
}