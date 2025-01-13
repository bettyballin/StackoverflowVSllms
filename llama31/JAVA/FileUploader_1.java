import java.io.File;

public class FileUploader_1_1 {
    File fNew;

    public FileUploader_1(File fi) {
        fNew = new File("/uploads", fi.getName());
    }

    public static void main(String[] args) {
    }
}