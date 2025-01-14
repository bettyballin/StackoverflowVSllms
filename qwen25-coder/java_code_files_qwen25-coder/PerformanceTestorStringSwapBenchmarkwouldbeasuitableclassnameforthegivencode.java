public class PerformanceTest {
    public static void main(String[] args) {
        String baseString = "abcdefghij"; // Adjust length as needed
        int iterations = 10000;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            swapAdjacent(baseString);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    public static String swapAdjacent(String str) {
        // Implementation for swapping adjacent characters
        if (str == null || str.length() < 2) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str.length());

        for (int i = 0; i < str.length() - 1; i += 2) {
            sb.append(str.charAt(i + 1));
            sb.append(str.charAt(i));
        }

        if (str.length() % 2 != 0) {
            sb.append(str.charAt(str.length() - 1));
        }

        return sb.toString();
    }
}