/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ImageSimilarityCalculator {
    public static void main(String[] stringArray) {
        String[] stringArray2 = "keyword1,keyword2,keyword3".split(",");
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(stringArray2));
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        HashMap<String, Double> hashMap2 = new HashMap<String, Double>();
        HashSet<String> hashSet2 = new HashSet<String>();
        int n = 100;
        HashMap<String, Integer> hashMap3 = new HashMap<String, Integer>();
        hashMap2.put("keyword1", 0.5);
        hashMap2.put("keyword2", 0.3);
        hashSet2.add("keyword1");
        hashSet2.add("keyword2");
        hashMap3.put("keyword1", 10);
        hashMap3.put("keyword2", 20);
        hashMap3.put("keyword3", 30);
        for (String string : hashSet) {
            double d = (double)hashSet.size() / (double)stringArray2.length;
            double d2 = Math.log((double)n / (double)(1 + hashMap3.getOrDefault(string, 0)));
            hashMap.put(string, d * d2);
        }
        double d = 0.0;
        for (String string : hashSet) {
            if (!hashSet2.contains(string)) continue;
            d += (Double)hashMap.get(string) * (Double)hashMap2.get(string);
        }
        System.out.println("Similarity: " + (d /= Math.sqrt(hashSet.size() * hashSet2.size())));
    }
}
