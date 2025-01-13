/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_567 {
    public static String readFile(String string) throws IOException {
        return new String(Files.readAllBytes(Paths.get(string, new String[0])), StandardCharsets.UTF_8);
    }

    public static void main(String[] stringArray) {
        try {
            System.out.println(Main_567.readFile("path_to_your_file.txt"));
        }
        catch (IOException iOException) {
            System.out.println("Error reading file: " + iOException.getMessage());
        }
    }
}
