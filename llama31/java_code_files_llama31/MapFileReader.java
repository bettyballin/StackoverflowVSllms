/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapFileReader {
    public static void main(String[] stringArray) {
        String string = "map.mp";
        File file = new File(string);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
            }
            catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Error reading file: " + fileNotFoundException.getMessage());
            }
        } else {
            System.out.println("File not found.");
        }
    }
}
