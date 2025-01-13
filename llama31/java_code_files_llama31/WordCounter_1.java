/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordCounter_1 {
    public static long countWords(String string2) throws IOException {
        return Files.lines(Paths.get(string2, new String[0])).flatMap(string -> Stream.of(string.split("\\s+"))).count();
    }

    public static void main(String[] stringArray) throws IOException {
        String string = "example.txt";
        long l = WordCounter_1.countWords(string);
        System.out.println("Total words: " + l);
    }
}
