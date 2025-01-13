import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFromByteArray {
    public static void main(String[] args) {
        // Your byte array image data
        byte[] imageData = { /* your byte array image data */ };

        // Encode the byte array to Base64
        String base64EncodedImage = Base64.getEncoder().encodeToString(imageData);

        // Create a data URI
        String dataUri = "data:image/png;base64," + base64EncodedImage;

        // Create a JFrame to display the image
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an ImageIcon from the data URI
        ImageIcon icon = new ImageIcon(dataUri);

        // Create a JLabel to display the icon
        JLabel label = new JLabel(icon);

        // Add the label to the frame
        frame.getContentPane().add(label);

        // Set the frame size
        frame.setSize(400, 400);

        // Make the frame visible
        frame.setVisible(true);
    }
}