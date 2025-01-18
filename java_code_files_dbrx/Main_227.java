import java.lang.String;
import java.awt.*;

public class Main_227 {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] allDisplays = ge.getScreenDevices();

        for (int i=0; i<allDisplays.length; i++) {
            DisplayMode dm = allDisplays[i].getDisplayMode();
            int width = dm.getWidth();
            int height = dm.getHeight();
            System.out.println("Screen " + (i+1) + ": (" + width + ", "+height+")");
        }
    }
}