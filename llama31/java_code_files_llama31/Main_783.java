/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_783 {
    public static void main(String[] stringArray) {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt");){
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}
