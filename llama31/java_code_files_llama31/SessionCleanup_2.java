/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class SessionCleanup_2 {
    public static void sessionCleanup() {
        String string2 = "/path/to/sessions";
        int n = 3600;
        File file2 = new File(string2);
        File[] fileArray = file2.listFiles((file, string) -> string.startsWith("sess_"));
        if (fileArray != null) {
            for (File file3 : fileArray) {
                long l = file3.lastModified() / 1000L;
                if (l + (long)n >= System.currentTimeMillis() / 1000L) continue;
                try {
                    if (file3.delete()) continue;
                    System.out.println("Failed to delete file: " + file3.getName());
                }
                catch (SecurityException securityException) {
                    System.out.println("Security exception occurred while deleting file: " + file3.getName());
                }
            }
        }
    }

    public static void main(String[] stringArray) {
        SessionCleanup_2.sessionCleanup();
    }
}
