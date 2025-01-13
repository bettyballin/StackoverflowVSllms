/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main_162 {
    public static void main(String[] stringArray) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream("out.txt"));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (Main_162.isSpecial(string)) {
                    String string2 = Main_162.editLine(string);
                    printWriter.println(string2);
                    continue;
                }
                printWriter.println(string);
            }
        }
    }

    private static boolean isSpecial(String string) {
        return false;
    }

    private static String editLine(String string) {
        return string;
    }
}
