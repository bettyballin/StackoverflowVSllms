import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class ImageUploader_1_1 {
    // Example of storing an image in a directory within the context path
    public void uploadImage(Part uploadedImage, ServletContext context) throws IOException {
        String imagePath = context.getRealPath("/images/" + uploadedImage.getName());
        File imageFile = new File(imagePath);
        uploadedImage.write(imageFile);
    }

    public static void main(String[] args) {
    }
}