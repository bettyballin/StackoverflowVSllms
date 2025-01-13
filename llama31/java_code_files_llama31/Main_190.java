/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;

public class Main_190 {
    public static String getUniqueFileName(String string, String string2) {
        try {
            File file = File.createTempFile(null, null, new File(string));
            String string3 = file.getName();
            file.delete();
            return string3 + string2;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_190.getUniqueFileName("/tmp", ".txt"));
    }
}
