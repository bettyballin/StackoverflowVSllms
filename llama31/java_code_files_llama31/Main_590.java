/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_590 {
    public static void main(String[] stringArray) throws IOException {
        byte[] byArray = new byte[]{};
        File file = File.createTempFile("temp", ".tmp");
        file.deleteOnExit();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
            fileOutputStream.write(byArray);
        }
    }
}
