import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleApplet extends JApplet {
    private JTextArea output;
    private JTextField input;

    public void init() {
        output = new JTextArea(20, 40);
        output.setEditable(false);

        input = new JTextField(40);
        input.addActionListener(new InputHandler());

        add(new JScrollPane(output), BorderLayout.CENTER);
        add(input, BorderLayout.SOUTH);
    }

    private class InputHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = input.getText();
            // Process the command here
            output.append(cmd + "\n");
            input.setText("");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Console Applet");
        ConsoleApplet applet = new ConsoleApplet();
        applet.init();
        frame.add(applet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}