import java.lang.String;
public class AddressMatcher {
    public static int levenshteinDistance(String s1, String s2) {
        int[] costs = new int[s2.length() + 1];
        for (int j = 0; j < costs.length; j++) {
            costs[j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= s2.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), s1.charAt(i - 1) == s2.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[s2.length()];
    }

    public static boolean isSimilar(String addr1, String addr2) {
        int distance = levenshteinDistance(addr1, addr2);
        return distance <= 2; // adjust the threshold as needed
    }

	public static void main(String[] args) {
	}
}