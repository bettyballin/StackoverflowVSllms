/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class SessionCleanup {
    public static void sessionCleanup() {
        String string = "/path/to/sessions";
        int n = 3600;
        File file = new File(string);
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File file2 : fileArray) {
                if (!file2.getName().startsWith("sess_") || file2.lastModified() + (long)(n * 1000) >= System.currentTimeMillis()) continue;
                try {
                    file2.delete();
                }
                catch (SecurityException securityException) {
                    System.err.println("Error deleting file: " + securityException.getMessage());
                }
            }
        }
    }

    public static void main(String[] stringArray) {
        SessionCleanup.sessionCleanup();
    }
}
