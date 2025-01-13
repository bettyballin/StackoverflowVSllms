public class AddressNormalizer {
    public static void main(String[] args) {
        // Example normalized address
        String normalizedAddress = "Quellenstrasse 66/11";

        // Levenshtein distance similarity search
        int threshold = 2; // adjust this value to your needs
        String[] existingAddresses = { "Quellenstrasse 66/10", "Quellenstrasse 67/11", "Quellenstrasse 66/11" }; // Example existing addresses

        for (String existingAddress : existingAddresses) {
            int distance = levenshteinDistance(normalizedAddress, existingAddress);
            if (distance <= threshold) {
                System.out.println("Similar address found: " + existingAddress + ". Distance: " + distance);
                // Similar address found, prevent registration or perform other logic
            }
        }
    }

    // Levenshtein distance implementation
    public static int levenshteinDistance(String s1, String s2) {
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
}