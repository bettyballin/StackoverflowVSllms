/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] stringArray) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("yourfile.txt"));
            bufferedReader.close();
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("yourfile.txt"));
            bufferedReader.close();
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
    }
}
