import java.io.File;
import java.io.IOException;

public class ImageUploader {
    // Example of storing an image in an external directory
    public static void main(String[] args) {
        String imagePath = "/var/images/" + "example_image.jpg"; // uploadedImage.getName();
        File imageFile = new File(imagePath);
        try {
            // uploadedImage.write(imageFile);
            // Note: The 'uploadedImage' object and its 'write' method are not defined in this snippet.
            // You would need to implement or import the necessary classes for image handling.
            System.out.println("Image uploaded to: " + imageFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error uploading image: " + e.getMessage());
        }
    }
}