import java.lang.String;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Chooser Example");
        JButton button = new JButton("Select File");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("Selected File: " + selectedFilePath);
                }
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}