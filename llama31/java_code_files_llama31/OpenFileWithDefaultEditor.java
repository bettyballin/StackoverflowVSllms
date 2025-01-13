/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Desktop;
import java.io.File;

public class OpenFileWithDefaultEditor {
    public static void main(String[] stringArray) {
        File file = new File("path/to/your/file.csv");
        try {
            Desktop.getDesktop().edit(file);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}
