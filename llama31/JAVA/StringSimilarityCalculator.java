import java.lang.String;

public class StringSimilarityCalculator {
    public int strSimilarity(String str1, String str2) {
        int score = 0;
        int minLen = Math.min(str1.length(), str2.length());
        int maxLen = Math.max(str1.length(), str2.length());
        int i = 0;

        while (i < minLen && str1.charAt(i) == str2.charAt(i)) {
            score++;
            i++;
        }

        return score * 100 / maxLen;
    }

    public static void main(String[] args) {
        StringSimilarityCalculator calculator = new StringSimilarityCalculator();
        String str1 = "example";
        String str2 = "example123";
        int similarity = calculator.strSimilarity(str1, str2);
        System.out.println("Similarity: " + similarity + "%");
    }
}