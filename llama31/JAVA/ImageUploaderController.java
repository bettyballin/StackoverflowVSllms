import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploaderController {
    // Upload image to server
    @PostMapping("/upload-image")
    public String uploadImage(@RequestParam("image") MultipartFile image) {
        // Validate image
        if (!image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/png")) {
            return "Invalid image type";
        }

        // Store image in file system
        String imageName = UUID.randomUUID().toString() + ".jpg";
        File imageFile = new File("/path/to/images/" + imageName);
        try {
            image.transferTo(imageFile);
        } catch (IllegalStateException | IOException e) {
            return "Failed to upload image";
        }

        // Store image metadata in database (e.g., user ID, image name)
        // ...

        return "Image uploaded successfully";
    }

    public static void main(String[] args) {
    }
}