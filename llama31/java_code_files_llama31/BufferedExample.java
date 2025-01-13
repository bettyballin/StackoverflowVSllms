/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedExample {
    public static void main(String[] stringArray) {
        String string = "input.txt";
        String string2 = "output.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string2));){
            String string3;
            while ((string3 = bufferedReader.readLine()) != null) {
                bufferedWriter.write(string3);
                bufferedWriter.newLine();
            }
        }
        catch (IOException iOException) {
            System.err.println("Error: " + iOException.getMessage());
        }
    }
}
