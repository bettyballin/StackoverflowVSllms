/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFileReader {
    public static void main(String[] stringArray) {
        TextFileReader textFileReader = new TextFileReader();
        textFileReader.readFile();
    }

    public void readFile() {
        try (InputStream inputStream = this.getClass().getResourceAsStream("path/to/your/textfile.txt");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        }
        catch (IOException iOException) {
            System.err.println("Error reading file: " + iOException.getMessage());
        }
    }
}
