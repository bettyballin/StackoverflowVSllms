/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.io.IOException;

public class Main_175 {
    public static void main(String[] stringArray) {
        String string = "path/to/your/file.txt";
        String string2 = "Hello, World!";
        try (FileWriter fileWriter = new FileWriter(string, true);){
            fileWriter.write(string2);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}
