import java.lang.String;
import java.applet.Applet;
import javax.swing.JApplet;

public class SampleApplet extends JApplet {

    public void init() {
        System.out.println("SampleApplet: Initialization");
    }

    public void start() {
        System.out.println("SampleApplet: Starting");
    }

    public void stop() {
        System.out.println("SampleApplet: Stopping");
        // Cleanup resources here if possible
    }

    public void destroy() {
        System.out.println("SampleApplet: Destroying");
        // Final cleanup here if possible
    }

	public static void main(String[] args) {
	}
}