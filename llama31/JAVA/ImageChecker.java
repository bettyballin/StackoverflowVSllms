import java.io.File;

public class ImageChecker {
    public static void main(String[] args) {
        String imagePath = "/path/to/your/image/myimage.jpg"; // replace with your actual image path
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            System.out.println("Image exists");
            // display the image
        } else {
            System.out.println("Image does not exist");
            // display a default image
        }
    }
}