import javax.swing.*;
import java.awt.*;

public class HelloWorldApp extends JFrame {
    public HelloWorldApp() {
        initComponents();
    }

    private void initComponents() {
        JLabel label = new JLabel("Hello, World!");
        add(label, BorderLayout.CENTER);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new HelloWorldApp().setVisible(true);
    }
}