import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordCounter_1 {
    public static long countWords(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .flatMap(line -> java.util.stream.Stream.of(line.split("\\s+")))
                .count();
    }

    public static void main(String[] args) throws IOException {
        String filename = "example.txt"; // replace with your file
        long wordCount = countWords(filename);
        System.out.println("Total words: " + wordCount);
    }
}