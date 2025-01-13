/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main_174 {
    public static void main(String[] stringArray) {
        String string = "path/to/your/file.txt";
        String string2 = "Hello, World!";
        try {
            Files.write(Paths.get(string, new String[0]), string2.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}
