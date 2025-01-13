/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TSVFileValidator {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean validateTSVFileFormat(String string) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string));){
            String string2;
            for (int i = 0; (string2 = bufferedReader.readLine()) != null && i < 5; ++i) {
                String[] stringArray = string2.split("\t");
                if (stringArray.length >= 2) continue;
                boolean bl = false;
                return bl;
            }
            boolean bl = true;
            return bl;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        String string = "path/to/your/file.tsv";
        boolean bl = TSVFileValidator.validateTSVFileFormat(string);
        System.out.println("Is the TSV file format valid? " + bl);
    }
}
