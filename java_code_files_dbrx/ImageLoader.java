import java.lang.String;
import java.net.URL;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.resource.ImageDescriptor;
public class ImageLoader {
    private Image fetchButtonImage(String imgPath) {
        if (imgPath == null || imgPath.isEmpty()) {
            return null;
        }
        URL iconURL = getClass().getResource("/" + imgPath); // replace '/' with '\\' for Windows file path
        final ImageDescriptor descriptor;
        try {
            descriptor = ImageDescriptor.createFromURL(iconURL);
        } catch (Exception e) {
            System.out.println("Image not found at: " + iconURL);
            return null; // handle null image accordingly in further code execution
        }
        return descriptor != null ? descriptor.createImage() : null;
    }
    public static void main(String[] args) {
    }
}