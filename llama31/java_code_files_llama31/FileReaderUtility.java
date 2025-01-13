/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderUtility {
    public static void main(String[] stringArray) {
        BufferedReader bufferedReader;
        Path path = Paths.get("yourfile.txt", new String[0]);
        try {
            bufferedReader = Files.newBufferedReader(path);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
        try {
            bufferedReader = Files.newBufferedReader(path);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
    }
}
