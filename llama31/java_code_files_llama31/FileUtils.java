/*
 * Decompiled with CFR 0.152.
 */
public class FileUtils {
    public static String formatFileSize(long l) {
        if (l < 1024L) {
            return "" + l;
        }
        if (l < 0x100000L) {
            return String.format("%.1fK", (double)l / 1024.0);
        }
        if (l < 0x40000000L) {
            return String.format("%.1fM", (double)l / 1048576.0);
        }
        return String.format("%.1fG", (double)l / 1.073741824E9);
    }

    public static void main(String[] stringArray) {
    }
}
