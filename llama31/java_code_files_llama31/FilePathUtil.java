/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FilePathUtil {
    public static void main(String[] stringArray) {
        String string = "C:\\Path\\To\\FileA.dll";
        String string2 = "C:\\Another\\Path\\To\\FileB.dll";
        String string3 = FilePathUtil.getRelativePath(string, string2);
        System.out.println("Relative path: " + string3);
    }

    private static String getRelativePath(String string, String string2) {
        int n;
        File file = new File(string);
        File file2 = new File(string2);
        String[] stringArray = file.getAbsolutePath().split("\\\\");
        String[] stringArray2 = file2.getAbsolutePath().split("\\\\");
        int n2 = FilePathUtil.findCommonPrefix(stringArray, stringArray2);
        StringBuilder stringBuilder = new StringBuilder();
        for (n = n2; n < stringArray2.length; ++n) {
            stringBuilder.append("..\\");
        }
        for (n = n2; n < stringArray.length; ++n) {
            stringBuilder.append(stringArray[n]).append("\\");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static int findCommonPrefix(String[] stringArray, String[] stringArray2) {
        int n;
        for (n = 0; n < stringArray.length && n < stringArray2.length && stringArray[n].equals(stringArray2[n]); ++n) {
        }
        return n;
    }
}
