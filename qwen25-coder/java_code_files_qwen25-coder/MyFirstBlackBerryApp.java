import javax.swing.*;
import java.awt.event.*;

public class MyFirstBlackBerryApp {

    public static void main(String[] args) {
        MyFirstBlackBerryApp app = new MyFirstBlackBerryApp();
    }

    public MyFirstBlackBerryApp() {
        JFrame frame = new JFrame("My First App");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Add window listener for close operation
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "Thanks for using the app!");
                System.exit(0);
            }
        });

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menu
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        // Create menu item
        JMenuItem aboutItem = new JMenuItem("About");
        menu.add(aboutItem);

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This is my first BlackBerry app.");
            }
        });

        frame.setJMenuBar(menuBar);

        // Set size and make visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}