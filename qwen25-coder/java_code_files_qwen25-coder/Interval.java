import java.lang.String;

public class Interval {

    class IntervalData {
        int low, high;

        IntervalData(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    class ITNode {
        IntervalData i;  // 'i' could also be a date range object in your case
        int max;
        ITNode left, right;

        ITNode(IntervalData i) {
            this.i = i;
            this.max = i.high;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
    }
}