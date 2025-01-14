import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenRecorder {
    private Robot robot;
    private Rectangle captureSize;

    public ScreenRecorder() throws AWTException {
        this.robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.captureSize = new Rectangle(screenSize);
    }

    public BufferedImage captureScreen() throws IOException, AWTException {
        return robot.createScreenCapture(captureSize);
    }

    public static void main(String[] args) {
        try {
            ScreenRecorder recorder = new ScreenRecorder();
            while (true) { // Simplified loop for capturing frames
                BufferedImage capture = recorder.captureScreen();
                ImageIO.write(capture, "png", new File("screencapture.png"));
                Thread.sleep(100); // Delay between captures
            }
        } catch (AWTException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}