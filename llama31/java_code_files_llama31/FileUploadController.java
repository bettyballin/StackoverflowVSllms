/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.RestController
 *  org.springframework.web.multipart.MultipartFile
 */
import java.io.InputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @PostMapping(value={"/upload"})
    public String handleFileUpload(@RequestParam(value="file") MultipartFile multipartFile) {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (Exception exception) {
            return "Error uploading file!";
        }
        return "File uploaded successfully!";
    }

    public static void main(String[] stringArray) {
    }
}
