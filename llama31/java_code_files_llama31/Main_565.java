/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_565 {
    public static String readFile(String string) throws IOException {
        return new String(Files.readAllBytes(Paths.get(string, new String[0])));
    }

    public static void main(String[] stringArray) throws IOException {
        System.out.println(Main_565.readFile("path_to_your_file.txt"));
    }
}
