import javax.swing.*;

public class MyApplication_7 {
    public static void main(String[] args) {
        try {
            // Set Napkin Look and Feel
            UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create your GUI here
        JFrame frame = new JFrame("Napkin Look and Feel Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}