/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;

public class MyApp_2 {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("path/to/your/file.exe");
        file.createNewFile();
        Runtime.getRuntime().exec("path/to/your/file.exe");
    }
}
