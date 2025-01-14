import java.lang.String;
import java.io.File;
import java.text.SimpleDateFormat;

public class CheckFileTimestamp {
    public static void main(String[] args) {
        File file = new File("path/to/sendmailpm.jsp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (file.exists() && file.isFile()) {
            long lastModifiedTime = file.lastModified();
            String formattedDate = sdf.format(lastModifiedTime);
            System.out.println("Last modified time of sendmailpm.jsp: " + formattedDate);

            // Check against current system time
            long currentTime = System.currentTimeMillis();
            if (lastModifiedTime > currentTime) {
                System.out.println("Warning: The file was modified in the future.");
            } else {
                System.out.println("The file timestamp is valid.");
            }
        } else {
            System.out.println("File does not exist or it's not a regular file.");
        }
    }
}