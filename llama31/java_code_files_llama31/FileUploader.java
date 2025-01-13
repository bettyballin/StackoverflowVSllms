/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FileUploader {
    String uploadDir = "/uploads";

    public static void main(String[] stringArray) {
        FileUploader fileUploader = new FileUploader();
        fileUploader.upload();
    }

    public void upload() {
        File file = new File(this.uploadDir, "example.txt");
    }
}
