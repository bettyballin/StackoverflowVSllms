import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ImageIcon icon;
        // Load image from local filesystem (for testing purpose)
        icon = new ImageIcon("C:/path_to_image/image.png");
        if (icon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
            InputStream is = Main.class.getResourceAsStream("/path_to_image/image.png");
            if (is != null) {
                try {
                    // Load image as a resource from inside your application when run as jar, or
                    // make images accessible via URL after deploying on web server
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    int nRead;
                    byte[] data = new byte[16384]; // or 4096, or more...
                    while ((nRead = is.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }
                    buffer.flush();
                    byte[] bytes = buffer.toByteArray();
                    InputStream in = new ByteArrayInputStream(bytes);
                    icon = new ImageIcon(ImageIO.read(in));
                } catch (IOException e2) {
                    // Error handlers
                    e2.printStackTrace();
                }
            } else {
                // error handler
                System.err.println("Error: Resource not found.");
            }
        }
    }
}