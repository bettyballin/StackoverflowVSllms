import java.lang.String;
public class Main_492 {
    public static void main(String[] args) {
        String str1 = "Robert";
        String str2 = "Amy Robertson";
        String str3 = "Richard";
        System.out.println(strSimilarity(str1, str2));
        System.out.println(strSimilarity(str1, str3));
    }

    public static int strSimilarity(String str1, String str2) {
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
}