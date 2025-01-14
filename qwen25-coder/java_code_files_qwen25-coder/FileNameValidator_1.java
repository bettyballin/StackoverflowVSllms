import java.lang.String;
import java.util.regex.Pattern;

public class FileNameValidator_1 {
    private static final Pattern ILLEGAL_CHARACTERS = Pattern.compile("[<>:\"/\\\\|?*]");
    private static final String[] RESERVED_NAMES = {"CON", "PRN", "AUX", "NUL",
            "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
            "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};

    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.isEmpty() ||
            ILLEGAL_CHARACTERS.matcher(fileName).find() ||
            fileName.endsWith(" ") || fileName.endsWith(".")) {
            return false;
        }
        
        // Check for reserved names
        String baseName = new java.io.File(fileName).getName();
        int dotIndex = baseName.lastIndexOf('.');
        String namePart = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);

        for (String reservedName : RESERVED_NAMES) {
            if (namePart.equalsIgnoreCase(reservedName)) {
                return false;
            }
        }

        // Consider national-specific characters valid
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidFileName("example.txt")); // true
        System.out.println(isValidFileName("exämple.txt")); // true, since it handles national characters
        System.out.println(isValidFileName("CON.txt"));     // false
        System.out.println(isValidFileName("example<.txt"));// false
    }
}