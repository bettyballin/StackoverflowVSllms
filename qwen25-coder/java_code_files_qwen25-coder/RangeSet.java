import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet;

import java.util.Set;

public class RangeSetExample {
    private final TreeRangeSet<Integer> rangeSet = TreeRangeSet.create();

    public void addRange(int start, int end) {
        if (start <= end) {
            rangeSet.add(Range.closed(start, end));
        }
    }

    public Set<Range<Integer>> intersects(Range<Integer> range) {
        return rangeSet.subRangeSet(range).asRanges();
    }

    // Example method to add Range object
    public void addRange(Range<Integer> range) {
        if (!range.isEmpty()) {
            rangeSet.add(range);
        }
    }

    // Example usage
    public static void main(String[] args) {
        RangeSetExample rangeSet = new RangeSetExample();
        rangeSet.addRange(1, 5);
        rangeSet.addRange(10, 20);

        Set<Range<Integer>> intersections = rangeSet.intersects(Range.closed(4, 15));

        for (Range<Integer> intersection : intersections) {
            System.out.println("Intersection: [" + intersection.lowerEndpoint() + ", " + intersection.upperEndpoint() + "]");
        }
    }
}