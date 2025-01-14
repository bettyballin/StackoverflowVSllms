import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGWTApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MyGWTApp().onModuleLoad();
        });
    }

    public void onModuleLoad() {
        JFrame frame = new JFrame("MyGWTApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel myLabel = new JLabel("Click the button to toggle highlight!");
        myLabel.setOpaque(true);
        myLabel.setBackground(null);

        JButton myButton = new JButton("Toggle Highlight");
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if ("highlight".equals(myLabel.getClientProperty("class"))) {
                    myLabel.putClientProperty("class", null);
                    myLabel.setBackground(null);
                } else {
                    myLabel.putClientProperty("class", "highlight");
                    myLabel.setBackground(Color.YELLOW);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(myLabel);
        panel.add(myButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}