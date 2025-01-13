/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class SessionCleanup_1 {
    public static void sessionCleanup() {
        String string = "/path/to/sessions";
        int n = 3600;
        File file = new File(string);
        File[] fileArray = file.listFiles();
        long l = System.currentTimeMillis() / 1000L;
        for (File file2 : fileArray) {
            long l2;
            if (!file2.getName().startsWith("sess_") || (l2 = file2.lastModified() / 1000L) + (long)n >= l) continue;
            file2.delete();
        }
    }

    public static void main(String[] stringArray) {
        SessionCleanup_1.sessionCleanup();
    }
}
