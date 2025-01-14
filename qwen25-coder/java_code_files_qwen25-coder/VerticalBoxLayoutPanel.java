import javax.swing.*;
import java.awt.*;

public class VerticalBoxLayoutPanel {
    // Using Box.createVerticalGlue() for more semantic clarity when not displaying anything

    JPanel panel = new JPanel();

    {
        panel.setLayout(new BorderLayout());
        panel.add(Box.createVerticalGlue(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
    }
}