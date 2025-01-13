import java.util.regex.Pattern;

public class FileNameValidator {
    public static boolean validateFileName(String fileName) {
        String regex = "^[a-zA-Z0-9_]+\\.tsv$"; // adjust the regex to your naming convention
        return Pattern.matches(regex, fileName);
    }

    public static void main(String[] args) {
        System.out.println(validateFileName("example_file.tsv")); // prints: true
        System.out.println(validateFileName("invalid file name.tsv")); // prints: false
    }
}