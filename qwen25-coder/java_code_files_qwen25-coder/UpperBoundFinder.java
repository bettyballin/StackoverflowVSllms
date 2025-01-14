import java.lang.String;
public abstract class UpperBoundFinder {
    int findUpperBoundWithKnownRange() {
        int low = 50; // lower bound of the range
        int high = 100; // upper bound of the range
        
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (test(mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return test(high) ? high : low; // Check the last element before high
    }

    abstract boolean test(int value);

    public static void main(String[] args) {
    }
}