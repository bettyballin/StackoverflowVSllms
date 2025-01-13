import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

// Using Spring MVC
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try (InputStream fileInputStream = file.getInputStream()) {
            // Process the file stream
        } catch (Exception e) {
            return "Error uploading file!";
        }
        return "File uploaded successfully!";
    }

    public static void main(String[] args) {
    }
}