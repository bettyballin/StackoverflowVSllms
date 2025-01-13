import java.lang.String;
import java.lang.Set;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LookAndFeelSetup {
    public static void main(String[] args) {
        try {
            // Set the LookAndFeel
            UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Error setting LookAndFeel: " + e.getMessage());
        }
    }
}