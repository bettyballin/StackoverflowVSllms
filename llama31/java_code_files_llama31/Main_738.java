/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class Main_738 {
    public static void main(String[] stringArray) {
        File file = new File("non_existent_file.txt");
        System.out.println(file.delete());
    }
}
