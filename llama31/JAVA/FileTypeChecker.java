import java.util.Arrays;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypeException;

public class FileTypeChecker {
    private static final Tika tika = new Tika();

    public boolean isFileTypeAllowed(byte[] fileBytes, String fileName) {
        try {
            String mimeType = tika.detect(fileBytes, fileName);
            // Check if the MIME type is in your whitelist
            return isMimeTypeInWhitelist(mimeType);
        } catch (MimeTypeException e) {
            // Handle the exception
            return false;
        }
    }

    private boolean isMimeTypeInWhitelist(String mimeType) {
        // Check if the MIME type is in your whitelist
        // For example:
        String[] whitelistedMimeTypes = {"application/pdf", "image/jpeg", "application/msword"};
        return Arrays.asList(whitelistedMimeTypes).contains(mimeType);
    }

    public static void main(String[] args) {
        FileTypeChecker fileTypeChecker = new FileTypeChecker();
        byte[] fileBytes = { /* your file bytes here */ };
        String fileName = "example.pdf";
        boolean isAllowed = fileTypeChecker.isFileTypeAllowed(fileBytes, fileName);
        System.out.println(isAllowed);
    }
}