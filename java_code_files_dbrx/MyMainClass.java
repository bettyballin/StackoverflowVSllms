import javax.swing.*;
public class MyMainClass {
    public static void main(String[] args) {
        // Set the look and feel as Nimbus (included in JDK 1.6+)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { // Or whatever look-and-feel you want to set, e.g., "GTK", etc.
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
           e.printStackTrace(); // Handle exceptions or do nothing if you don't care about exception handling
        }
        JFrame myFrame = new JFrame("My Application");
        // Your code here to populate the frame etc...
    }
}