import java.lang.String;

public class BinarySearcher_2_2 {
    public int findFirstPrefixMatch(String[] SA, String P) {
        int low = 0;
        int high = SA.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midStr = SA[mid];

            if (midStr.startsWith(P)) {
                // Found a match, but we need to find the first one
                if (mid == 0 || !SA[mid - 1].startsWith(P)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (midStr.compareTo(P) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // No match found
    }

    public static void main(String[] args) {
        BinarySearcher_2 searcher = new BinarySearcher_2();
        String[] SA = {"apple", "application", "apply", "banana", "bat"};
        String P = "ap";
        int index = searcher.findFirstPrefixMatch(SA, P);
        System.out.println("Index of first prefix match: " + index);
    }
}