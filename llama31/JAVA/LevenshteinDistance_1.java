import java.lang.String;
public class LevenshteinDistance_1 {
    public static int distance(String s1, String s2) {
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "Into the clear blue sky";
        String s2 = "The color is sky blue";
        String s3 = "In the blue clear sky";

        System.out.println("Distance between s1 and s2: " + distance(s1, s2));
        System.out.println("Distance between s1 and s3: " + distance(s1, s3));
    }
}