/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FileValidator {
    public static void main(String[] stringArray) {
        String string = "example.txt";
        File file = new File("path/to/permanent/location", string);
        if (!file.getParentFile().equals(new File("path/to/permanent/location"))) {
            System.out.println("Directory traversal attack detected!");
        }
    }
}
