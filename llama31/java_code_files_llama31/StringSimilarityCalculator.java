/*
 * Decompiled with CFR 0.152.
 */
public class StringSimilarityCalculator {
    public int strSimilarity(String string, String string2) {
        int n = 0;
        int n2 = Math.min(string.length(), string2.length());
        int n3 = Math.max(string.length(), string2.length());
        for (int i = 0; i < n2 && string.charAt(i) == string2.charAt(i); ++i) {
            ++n;
        }
        return n * 100 / n3;
    }

    public static void main(String[] stringArray) {
        StringSimilarityCalculator stringSimilarityCalculator = new StringSimilarityCalculator();
        String string = "example";
        String string2 = "example123";
        int n = stringSimilarityCalculator.strSimilarity(string, string2);
        System.out.println("Similarity: " + n + "%");
    }
}
