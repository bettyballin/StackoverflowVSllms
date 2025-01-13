/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class OpenPdfAtPage_1 {
    public static void main(String[] stringArray) {
        int n = 24;
        String string = "C:\\Program Files\\Foo\\Bar\\Docs\\RefMan.pdf";
        String string2 = "start \"" + string + "\" /A \"page=" + n + "=OpenActions\"";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", string2);
            processBuilder.start();
        }
        catch (IOException iOException) {
            System.err.println("Error opening PDF file: " + iOException.getMessage());
        }
    }
}
