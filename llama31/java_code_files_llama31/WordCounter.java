/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WordCounter {
    public static int countWords(String string) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string));){
            String string2;
            int n = 0;
            while ((string2 = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string2);
                while (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                    ++n;
                }
            }
            int n2 = n;
            return n2;
        }
    }

    public static void main(String[] stringArray) throws IOException {
        String string = "example.txt";
        int n = WordCounter.countWords(string);
        System.out.println("Total words: " + n);
    }
}
