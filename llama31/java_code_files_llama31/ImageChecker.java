/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class ImageChecker {
    public static void main(String[] stringArray) {
        String string = "/path/to/your/image/myimage.jpg";
        File file = new File(string);
        if (file.exists()) {
            System.out.println("Image exists");
        } else {
            System.out.println("Image does not exist");
        }
    }
}
