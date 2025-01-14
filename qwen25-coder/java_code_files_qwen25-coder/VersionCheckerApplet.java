import java.lang.String;
import java.applet.Applet;

public class VersionCheckerApplet extends Applet {
    public void init() {
        System.out.println("Java Version: " + System.getProperty("java.version"));
    }

    public static void main(String[] args) {
    }
}