import javax.swing.*;
import java.awt.*;

public class MyView_1 extends JPanel {
    private JLabel nameLabel;
    private JTextField nameInput;

    public MyView() {
        nameLabel = new JLabel("Name:");
        nameInput = new JTextField();

        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameInput);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyView());
        frame.pack();
        frame.setVisible(true);
    }
}