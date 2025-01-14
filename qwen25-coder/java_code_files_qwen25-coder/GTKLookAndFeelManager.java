import java.lang.String;
import javax.swing.UIManager;

public class GTKLookAndFeelManager {
    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}