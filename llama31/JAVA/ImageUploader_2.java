import java.io.File;
import java.io.IOException;

public class ImageUploader_2_2 {
    // Example of storing an image in a shared directory
    public static void main(String[] args) {
        // You need to handle the file upload and then call the uploadImage method
        // For demonstration purposes, I assume that uploadedImage is a File
        File uploadedImage = new File("path_to_your_image.jpg");
        uploadImage(uploadedImage);
    }

    public static void uploadImage(File uploadedImage) {
        String imagePath = "/shared/images/" + uploadedImage.getName();
        File imageFile = new File(imagePath);
        try {
            // Using java.nio.file.Files to copy the file
            java.nio.file.Files.copy(uploadedImage.toPath(), imageFile.toPath());
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}