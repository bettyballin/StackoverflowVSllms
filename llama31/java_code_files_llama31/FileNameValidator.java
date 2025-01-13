/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class FileNameValidator {
    public static boolean validateFileName(String string) {
        String string2 = "^[a-zA-Z0-9_]+\\.tsv$";
        return Pattern.matches(string2, string);
    }

    public static void main(String[] stringArray) {
        System.out.println(FileNameValidator.validateFileName("example_file.tsv"));
        System.out.println(FileNameValidator.validateFileName("invalid file name.tsv"));
    }
}
