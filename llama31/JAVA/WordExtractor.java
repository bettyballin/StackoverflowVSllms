import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordExtractor {
    public static void main(String[] args) {
        String filePath = "path_to_your_text_file.txt";
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            Pattern pattern = Pattern.compile("\\b\\w[\\w']*$");
            Matcher matcher = pattern.matcher(content.toLowerCase());

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}