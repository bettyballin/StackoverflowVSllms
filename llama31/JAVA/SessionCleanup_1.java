import java.io.File;
import java.io.IOException;

public class SessionCleanup_1 {
    public static void sessionCleanup() {
        String sessionPath = "/path/to/sessions";
        int sessionTimeLimit = 3600; // 1 hour in seconds
        File directory = new File(sessionPath);
        File[] files = directory.listFiles();
        long currentTime = System.currentTimeMillis() / 1000;

        for (File file : files) {
            if (file.getName().startsWith("sess_")) {
                long fileLastModified = file.lastModified() / 1000;
                if (fileLastModified + sessionTimeLimit < currentTime) {
                    file.delete();
                }
            }
        }
    }

    public static void main(String[] args) {
        sessionCleanup();
    }
}