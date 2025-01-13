/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_620 {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"file1.txt", "file2.pdf", "file3.mp3", "file4.txt", "file5.pdf"};
        Arrays.sort(stringArray2, (string, string2) -> {
            String string3 = Main_620.getFileExtension(string);
            String string4 = Main_620.getFileExtension(string2);
            return string3.compareTo(string4);
        });
        for (String string3 : stringArray2) {
            System.out.println(string3);
        }
    }

    private static String getFileExtension(String string) {
        int n = string.lastIndexOf(46);
        if (n > 0) {
            return string.substring(n + 1);
        }
        return "";
    }
}
