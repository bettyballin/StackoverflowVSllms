/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_568 {
    public static String readFile(String string) throws IOException {
        return Files.readString(Paths.get(string, new String[0]), StandardCharsets.UTF_8);
    }

    public static void main(String[] stringArray) throws IOException {
        System.out.println(Main_568.readFile("example.txt"));
    }
}
