import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class CsvParser {

    String delimiter = ",";
    List<String[]> stringsArray = new ArrayList<>();

    public CsvParser() {
        try (Stream<String> stream = Files.lines(Paths.get("YourFilepath"))) {
            stream.forEach((line) -> {
                String[] items = line.split(delimiter);
                stringsArray.add(items);
            });
        } catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}