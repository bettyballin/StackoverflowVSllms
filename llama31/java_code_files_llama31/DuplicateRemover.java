/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class DuplicateRemover {
    public static void main(String[] stringArray) throws IOException {
        String string = "input.txt";
        String string2 = "output.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string2));){
            String string3;
            HashSet<String> hashSet = new HashSet<String>();
            while ((string3 = bufferedReader.readLine()) != null) {
                if (!hashSet.add(string3)) continue;
                bufferedWriter.write(string3);
                bufferedWriter.newLine();
            }
        }
    }
}
