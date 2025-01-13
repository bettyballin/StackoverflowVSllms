/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.io.IOException;

public class VirusWriter {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"Virus1", "Virus2", "Virus3"};
        int n = stringArray2[0].length();
        try (FileWriter fileWriter = new FileWriter("output.txt");){
            for (int i = 0; i < stringArray2.length; ++i) {
                fileWriter.write(stringArray2[i], 0, n);
            }
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}
