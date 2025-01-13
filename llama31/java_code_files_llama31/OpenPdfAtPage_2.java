/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class OpenPdfAtPage_2 {
    public static void main(String[] stringArray) throws IOException {
        String string = "/path/to/your/file.pdf";
        int n = 5;
        String string2 = "file://" + string + "#page=" + n;
        Desktop.getDesktop().browse(URI.create(string2));
    }
}
