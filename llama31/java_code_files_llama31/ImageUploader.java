/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class ImageUploader {
    public static void main(String[] stringArray) {
        String string = "/var/images/example_image.jpg";
        File file = new File(string);
        try {
            System.out.println("Image uploaded to: " + file.getAbsolutePath());
        }
        catch (Exception exception) {
            System.err.println("Error uploading image: " + exception.getMessage());
        }
    }
}
