import java.lang.String;
public class FileUtils {
    public static String formatFileSize(long fileSize) {
        if (fileSize < 1024) {
            return fileSize + "";
        } else if (fileSize < 1024 * 1024) {
            return String.format("%.1fK", fileSize / 1024.0);
        } else if (fileSize < 1024 * 1024 * 1024) {
            return String.format("%.1fM", fileSize / (1024.0 * 1024));
        } else {
            return String.format("%.1fG", fileSize / (1024.0 * 1024 * 1024));
        }
    }

	public static void main(String[] args) {
	}
}