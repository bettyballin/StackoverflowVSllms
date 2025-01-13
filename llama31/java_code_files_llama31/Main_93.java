/*
 * Decompiled with CFR 0.152.
 */
public class Main_93 {
    public static void main(String[] stringArray) {
        long l = 332L;
        String string = Main_93.formatDuration(l);
        System.out.println(string);
    }

    public static String formatDuration(long l) {
        long l2 = l / 3600L;
        long l3 = l % 3600L / 60L;
        long l4 = l % 60L;
        return String.format("%02d:%02d:%02d", l2, l3, l4);
    }
}
