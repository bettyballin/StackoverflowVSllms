/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVParser {
    public static void main(String[] stringArray) throws IOException {
        String string;
        String string2 = "example.csv";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(string2));
        while ((string = bufferedReader.readLine()) != null) {
            String[] stringArray2;
            for (String string3 : stringArray2 = string.split(",")) {
                if (string3.startsWith("\"") && string3.endsWith("\"")) {
                    string3 = string3.substring(1, string3.length() - 1);
                }
                string3 = string3.replace("\\,", ",");
                System.out.println(string3);
            }
        }
    }
}
