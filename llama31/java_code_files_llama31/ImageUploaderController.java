/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.multipart.MultipartFile
 */
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploaderController {
    @PostMapping(value={"/upload-image"})
    public String uploadImage(@RequestParam(value="image") MultipartFile multipartFile) {
        if (!multipartFile.getContentType().equals("image/jpeg") && !multipartFile.getContentType().equals("image/png")) {
            return "Invalid image type";
        }
        String string = UUID.randomUUID().toString() + ".jpg";
        File file = new File("/path/to/images/" + string);
        try {
            multipartFile.transferTo(file);
        }
        catch (IOException | IllegalStateException exception) {
            return "Failed to upload image";
        }
        return "Image uploaded successfully";
    }

    public static void main(String[] stringArray) {
    }
}
