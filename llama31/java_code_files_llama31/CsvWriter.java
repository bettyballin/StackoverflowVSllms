/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    public static void main(String[] stringArray) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fileName.csv"), 32768);
            bufferedWriter.close();
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}
