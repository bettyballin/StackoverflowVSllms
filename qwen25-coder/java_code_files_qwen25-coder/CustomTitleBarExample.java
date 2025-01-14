import java.lang.String;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTitleBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true); // Remove the default decorations
        frame.setLayout(new BorderLayout());
        
        JPanel titleBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("X");
        JButton customButton = new JButton("+");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Custom button clicked!");
            }
        });
        
        titleBar.add(customButton); // Add the custom function button first
        titleBar.add(closeButton);
        
        frame.add(titleBar, BorderLayout.NORTH);
        frame.add(new JLabel("Example Content", SwingConstants.CENTER), BorderLayout.CENTER);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}