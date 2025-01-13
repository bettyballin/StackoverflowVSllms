/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class DocumentOpener {
    public static void openDocument(String string) throws IOException {
        String[] stringArray = new String[]{"cmd.exe", "/c", "start", "\"" + string + "\""};
        ProcessBuilder processBuilder = new ProcessBuilder(stringArray);
        processBuilder.start();
    }

    public static void main(String[] stringArray) {
    }
}
