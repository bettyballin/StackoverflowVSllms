import java.io.File;
import java.io.IOException;

public class SessionCleanup_2 {
    public static void sessionCleanup() {
        String sessionPath = "/path/to/sessions";
        int sessionTimeLimit = 3600; // 1 hour in seconds
        File directory = new File(sessionPath);
        File[] files = directory.listFiles((dir, name) -> name.startsWith("sess_"));
        
        if (files != null) {
            for (File file : files) {
                long fileSize = file.lastModified() / 1000; // convert milliseconds to seconds
                if (fileSize + sessionTimeLimit < System.currentTimeMillis() / 1000) {
                    try {
                        if (!file.delete()) {
                            System.out.println("Failed to delete file: " + file.getName());
                        }
                    } catch (SecurityException e) {
                        System.out.println("Security exception occurred while deleting file: " + file.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        sessionCleanup();
    }
}