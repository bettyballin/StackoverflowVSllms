/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileParser {
    public static void main(String[] stringArray) throws IOException {
        String string = "path/to/your/file.txt";
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string));){
            String objectArray;
            while ((objectArray = bufferedReader.readLine()) != null) {
                String[] stringArray2 = objectArray.split(",");
                for (int i = 0; i < stringArray2.length; ++i) {
                    stringArray2[i] = stringArray2[i].trim().replaceAll("\"", "");
                }
                arrayList.add(stringArray2);
            }
        }
        for (Object[] objectArray : arrayList) {
            System.out.println(Arrays.toString(objectArray));
        }
    }
}
