import java.io.File;

public class FileUploader {
    // Define the upload directory path
    String uploadDir = "/uploads";

    public static void main(String[] args) {
        FileUploader uploader = new FileUploader();
        uploader.upload();
    }

    public void upload() {
        // Assuming fi is a File object
        File fNew = new File(uploadDir, "example.txt"); // Replace "example.txt" with fi.getName()
        // ...
    }
}