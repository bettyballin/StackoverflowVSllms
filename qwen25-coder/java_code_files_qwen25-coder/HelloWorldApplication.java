import java.lang.String;
import javax.swing.*;
public class HelloWorldApplication {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World Swing");
        JLabel label = new JLabel("Hello World!", SwingConstants.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}