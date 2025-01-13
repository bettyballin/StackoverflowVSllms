import java.lang.String;

public class StringDistanceCalculator_1_1 {
    public int hammingDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance + Math.abs(s1.length() - s2.length());
    }

    public static void main(String[] args) {
        StringDistanceCalculator_1 calculator = new StringDistanceCalculator_1();
        // Example usage:
        String s1 = "hello";
        String s2 = "world";
        int distance = calculator.hammingDistance(s1, s2);
        System.out.println("Hamming distance between '" + s1 + "' and '" + s2 + "': " + distance);
    }
}