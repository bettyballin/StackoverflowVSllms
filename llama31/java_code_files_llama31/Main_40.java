/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main_40 {
    public static void main(String[] stringArray) throws FileNotFoundException, IOException {
        String string;
        File file = new File("file1.txt");
        File file2 = new File("file2.txt");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file2, true);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while ((string = bufferedReader.readLine()) != null) {
            if (!string.contains("search_string") || string.contains("another_search_string")) continue;
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();
    }
}
