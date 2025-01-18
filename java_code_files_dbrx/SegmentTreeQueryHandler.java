import java.lang.String;

public class SegmentTreeQueryHandler {
    public int getSum(int seg[], int low, int high) {
        int N = seg.length;
        return helperFunction(seg, 0, N - 1, 1, low, high); // here we have a recursive function call. N will be array size and this is where the query is actually taking place for range [l..r]. All the queries take place between the current node pos*2 to (pos*2 + 1)
    }

    private int helperFunction(int seg[], int start, int end, int node, int low, int high) {
        // Implementation of the recursive function goes here
        // For now, returning 0 to allow compilation
        return 0;
    }

    public static void main(String[] args) {
    }
}