/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopy {
    public static void main(String[] stringArray) {
        String string = "path/to/source/file";
        String string2 = "path/to/destination/file";
        try {
            Files.copy(Paths.get(string, new String[0]), Paths.get(string2, new String[0]), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}
