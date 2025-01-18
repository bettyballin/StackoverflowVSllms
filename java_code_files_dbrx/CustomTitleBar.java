import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomTitleBar extends JPanel {
    public CustomTitleBar(JFrame frame) {
        setLayout(new BorderLayout()); // Using BorderLayout for simplicity
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(frame.getWidth(), 24)); // Adjust size as needed

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                frame.setLocation(
                    (int) (e.getXOnScreen() - getInsets().left),
                    (int) (e.getYOnScreen() - getInsets().top)
                );
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(
                    (int) (e.getXOnScreen() - getInsets().left),
                    (int) (e.getYOnScreen() - getInsets().top)
                );
            }
        });
    }

    public static void main(String[] args) {
    }
}