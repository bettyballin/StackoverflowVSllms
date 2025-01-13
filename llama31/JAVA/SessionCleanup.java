import java.io.File;
import java.io.IOException;

public class SessionCleanup {
    public static void sessionCleanup() {
        String sessionPath = "/path/to/sessions";
        int sessionTimeLimit = 3600; // 1 hour in seconds
        File directory = new File(sessionPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().startsWith("sess_")) {
                    if (file.lastModified() + sessionTimeLimit * 1000 < System.currentTimeMillis()) {
                        try {
                            file.delete();
                        } catch (SecurityException e) {
                            System.err.println("Error deleting file: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        sessionCleanup();
    }
}