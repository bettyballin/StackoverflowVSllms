/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main_49 {
    public static void main(String[] stringArray) {
        String string = "path/to/your/very_large_file.txt";
        try {
            System.out.println(Main_49.readLastLine(string));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static String readLastLine(String string) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(string)));){
            String string2;
            String string3 = "";
            while ((string2 = bufferedReader.readLine()) != null) {
                string3 = string2;
            }
            String string4 = string3;
            return string4;
        }
    }
}
