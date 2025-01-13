/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineCounter {
    public static void main(String[] stringArray) {
        String string = "path_to_your_file.txt";
        try {
            long l = Files.lines(Paths.get(string, new String[0])).count();
            System.out.println("Total lines: " + l);
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
    }
}
