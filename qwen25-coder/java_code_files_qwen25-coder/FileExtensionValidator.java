import java.util.Arrays;

public class FileExtensionValidator {
    String[] allowedExtensions = {".pdf", ".tiff"};
    String fileName = "example.pdf";
    boolean isValidExtension = Arrays.asList(allowedExtensions)
            .contains(FileUtils.getFilenameExtension(fileName).toLowerCase());

    public static class FileUtils {
        public static String getFilenameExtension(String fileName) {
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex != -1) {
                return fileName.substring(dotIndex);
            } else {
                return "";
            }
        }
    }

    public static void main(String[] args) {
    }
}