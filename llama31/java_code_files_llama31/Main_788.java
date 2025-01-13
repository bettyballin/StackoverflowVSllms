/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_788 {
    public static void main(String[] stringArray) {
        String string = Main_788.getPid();
        System.out.println("PID: " + string);
    }

    public static String getPid() {
        try {
            File file = new File("/proc/self/stat");
            Scanner scanner = new Scanner(file);
            String string = scanner.nextLine();
            scanner.close();
            return string.split(" ")[0];
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }
}
