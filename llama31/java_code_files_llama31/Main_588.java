/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main_588 {
    public static void main(String[] stringArray) {
        try {
            String string;
            FileWriter fileWriter = new FileWriter("example.txt");
            fileWriter.write("Name,Address,Phone\n");
            fileWriter.write("John Doe,123 Main St,123-456-7890\n");
            fileWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("example.txt"));
            while ((string = bufferedReader.readLine()) != null) {
                String[] stringArray2 = string.split(",");
                System.out.println("Name: " + stringArray2[0]);
                System.out.println("Address: " + stringArray2[1]);
                if (stringArray2.length <= 2) continue;
                System.out.println("Phone: " + stringArray2[2]);
            }
            bufferedReader.close();
        }
        catch (IOException iOException) {
            System.out.println("An error occurred while reading or writing to the file.");
        }
    }
}
