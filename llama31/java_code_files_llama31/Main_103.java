/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_103 {
    public static void main(String[] stringArray) {
        String string = "/path/to/your/file";
        Path path = Paths.get(string, new String[0]);
        int n = path.getNameCount();
        String[] stringArray2 = new String[n];
        for (int i = 0; i < n; ++i) {
            stringArray2[i] = path.getName(i).toString();
            System.out.println(stringArray2[i]);
        }
    }
}
