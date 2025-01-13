/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenPdfAtPage {
    public static void main(String[] stringArray) {
        int n = 24;
        String string = "C:\\Program Files\\Foo\\Bar\\Docs\\RefMan.pdf";
        try {
            Desktop.getDesktop().open(new File(string + "#page=" + n));
        }
        catch (IOException iOException) {
            System.err.println("Error opening PDF file: " + iOException.getMessage());
        }
    }
}
