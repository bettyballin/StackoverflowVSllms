/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Uniq {
    public static void main(String[] stringArray) {
        if (stringArray.length != 1) {
            System.out.println("Usage: java Uniq <filename>");
            return;
        }
        String string = stringArray[0];
        HashSet<String> hashSet = new HashSet<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string));){
            String string2;
            while ((string2 = bufferedReader.readLine()) != null) {
                String[] stringArray2 = string2.split("\\s+");
                if (stringArray2.length <= 0 || !hashSet.add(stringArray2[0])) continue;
                System.out.println(string2);
            }
        }
        catch (IOException iOException) {
            System.out.println("Error reading file: " + iOException.getMessage());
        }
    }
}
