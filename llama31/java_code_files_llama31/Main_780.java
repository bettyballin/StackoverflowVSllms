/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_780 {
    public static void main(String[] stringArray) {
        try {
            File file = new File("hs_err_pidXXX.log");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                if (!string.contains("EXCEPTION_ACCESS_VIOLATION")) continue;
                System.out.println(string);
            }
            scanner.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
        }
    }
}
