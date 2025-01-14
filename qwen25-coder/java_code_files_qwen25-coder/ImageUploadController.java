import java.lang.String;
// Sample backend code to handle file uploads securely in Java with Spring Boot

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            if (isAllowedFile(file.getOriginalFilename())) {
                // Save the file to a secure location and generate a unique URL for it
                saveFile(file);
                // Respond with the image URL or metadata
                return "redirect:/imageuploaded";
            } else {
                throw new Exception("Invalid file type");
            }
        } catch (Exception e) {
            // Log error
            return "redirect:/uploaderror";
        }
    }

    private boolean isAllowedFile(String filename) {
        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
        String[] allowedExtensions = {"png", "jpeg", "jpg", "gif"};
        for (String ext : allowedExtensions) {
            if (ext.equals(extension)) return true;
        }
        return false;
    }

    private void saveFile(MultipartFile file) throws Exception {
        // Implement saving and secure storage of the file
        throw new UnsupportedOperationException("Not implemented yet");
    }

	public static void main(String[] args) {
	}
}