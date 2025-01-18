import javax.swing.*;
import java.awt.*;

public class AppletTest extends JApplet {
    private long lastFrame = 0;

    public void init() {
        setSize(320, 160);
        setBackground(Color.white);
        new Timer(50, e -> repaint()).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        long now = System.nanoTime();
        if (lastFrame != 0 && lastFrame > now || Utils.sleepAllowedFor60fps(lastFrame, now)) {
            Thread.yield();
            try {
                Thread.sleep(Math.max(1, Math.round((float) Utils.nanosecondsUntilSleepEnd(lastFrame, now) / 1_000_000)));
            } catch (InterruptedException ignored) {}
        } else {
            lastFrame = now;
        }
        g.setColor(getBackground()); // to prevent artifacts during background color update in some OS's
        g.drawString("Welcome to Java!!", 50, 60);
    }

    public static void main(String[] args) {
    }
}

class Utils {
    public static boolean sleepAllowedFor60fps(long lastFrame, long now) {
        return nanosecondsUntilSleepEnd(lastFrame, now) > 0;
    }

    public static long nanosecondsUntilSleepEnd(long lastFrame, long now) {
        final long targetFrameDuration = 16_666_667; // nanoseconds per frame for 60 fps
        long timeSinceLastFrame = now - lastFrame;
        return targetFrameDuration - timeSinceLastFrame;
    }
}