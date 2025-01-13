public class Main_619 {
    /**
     * Finds the index of the first string in the array SA that starts with the prefix P.
     * 
     * @param SA the array of strings to search in
     * @param P the prefix to search for
     * @return the index of the first string that starts with P, or -1 if no such string is found
     */
    public static int findFirstPrefixMatch(String[] SA, String P) {
        for (int i = 0; i < SA.length; i++) {
            if (SA[i].startsWith(P)) {
                return i;
            }
        }
        return -1; // Return -1 if no prefix match is found
    }

    /**
     * Main method to test the findFirstPrefixMatch function.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String[] SA = {"ab", "abd", "abdf", "abz"};
        String P = "abd";
        int result = findFirstPrefixMatch(SA, P);
        System.out.println(result); // Output: 1
    }
}