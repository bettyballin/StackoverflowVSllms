import java.lang.String;
import java.awt.*;
import java.applet.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppletTest extends Applet {

    private ScheduledExecutorService executor;

    public void init() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::updateAndRepaint, 0, 16, TimeUnit.MILLISECONDS);
    }

    public void paint(Graphics g) {
        g.drawString("Welcome to Java!!", 50, 60);
    }

    private void updateAndRepaint() {
        // Add your game logic here
        repaint();
    }

    public void destroy() {
        executor.shutdown();
    }

	public static void main(String[] args) {
	}
}