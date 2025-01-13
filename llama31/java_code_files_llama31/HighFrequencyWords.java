/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFrequencyWords {
    public static void main(String[] stringArray) throws IOException {
        Object object;
        String string = "path_to_your_text_file.txt";
        int n = 10;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        try (Object object2 = new BufferedReader(new FileReader(string));){
            String string2;
            while ((string2 = ((BufferedReader)object2).readLine()) != null) {
                object = string2.split("\\s+");
                for (String string3 : object) {
                    string3 = string3.toLowerCase();
                    hashMap.put(string3, hashMap.getOrDefault(string3, 0) + 1);
                }
            }
        }
        object2 = new PriorityQueue((entry, entry2) -> ((Integer)entry2.getValue()).compareTo((Integer)entry.getValue()));
        ((AbstractQueue)object2).addAll(hashMap.entrySet());
        for (int i = 0; i < n; ++i) {
            object = (Map.Entry)((PriorityQueue)object2).poll();
            System.out.println((String)object.getKey() + ": " + String.valueOf(object.getValue()));
        }
    }
}
