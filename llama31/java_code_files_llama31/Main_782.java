/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;

public class Main_782 {
    public static void main(String[] stringArray) {
        try {
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            fileInputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
