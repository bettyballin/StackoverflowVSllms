import java.io.File;
import java.util.regex.Pattern;

public class FileNameValidator {

    // Define a regex pattern for valid file names
    // This pattern excludes some common invalid characters: /\:*?"<>|
    private static final Pattern VALID_FILE_NAME_PATTERN = 
        Pattern.compile("[^\\\\p{IsCombiningDiacriticalMarks}][a-zA-Z0-9._ -]+");

    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.length() > 255) {
            return false; // Null or too long file names are invalid
        }

        return VALID_FILE_NAME_PATTERN.matcher(fileName).matches();
    }

    public static boolean OKtoRename(String oldName, String newName) {
        File newFile = new File(newName);
        
        // Check if the new name is not already taken and is a valid file name
        return !newFile.exists() && isValidFileName(newName);
    }

    public static void main(String[] args) {
        System.out.println(OKtoRename("old.txt", "valid-name.txt")); // true/false based on existence
        System.out.println(isValidFileName("invalid|name.txt")); // false
    }
}