import java.util.HashMap;
import java.util.TreeSet;

public class MaxCache_1 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private TreeSet<Element> set = new TreeSet<>();

    // Class Element to store value and an index (to handle dupes uniquely)
    static class Element implements Comparable<Element> {
        int val;
        int idx;

        Element(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Element o) {
            if (this.val != o.val) return Integer.compare(this.val, o.val);
            else return Integer.compare(this.idx, o.idx); // Use index to differentiate
        }
    }

    int count; // Unique index to handle duplicate values

    public void insert(int value) {
        final int idx = count++;
        map.put(idx, value);
        set.add(new Element(value, idx));
    }

    public void delete(int index) {
        if (map.containsKey(index)) {
            final int val = map.get(index);
            set.remove(new Element(val, index));
            map.remove(index);
        }
    }

    public Integer getMax() {
        return !set.isEmpty() ? set.last().val : null;
    }

    public static void main(String[] args) {
    }
}