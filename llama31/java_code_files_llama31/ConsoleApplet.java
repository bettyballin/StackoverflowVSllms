/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsoleApplet
extends JApplet {
    private JTextArea output;
    private JTextField input;

    @Override
    public void init() {
        this.output = new JTextArea(20, 40);
        this.output.setEditable(false);
        this.input = new JTextField(40);
        this.input.addActionListener(new InputHandler());
        this.add((Component)new JScrollPane(this.output), "Center");
        this.add((Component)this.input, "South");
    }

    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("Console Applet");
        ConsoleApplet consoleApplet = new ConsoleApplet();
        consoleApplet.init();
        jFrame.add(consoleApplet);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);
    }

    private class InputHandler
    implements ActionListener {
        private InputHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String string = ConsoleApplet.this.input.getText();
            ConsoleApplet.this.output.append(string + "\n");
            ConsoleApplet.this.input.setText("");
        }
    }
}
