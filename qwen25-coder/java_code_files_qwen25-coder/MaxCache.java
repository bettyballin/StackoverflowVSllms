import java.util.HashMap;
import java.util.PriorityQueue;

public class MaxCache {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private PriorityQueue<Element> maxHeap = new PriorityQueue<>((a, b) -> {
        // Compare by value first, then by index to handle duplicates uniquely
        if (!a.val.equals(b.val)) return b.val - a.val;
        else return a.idx - b.idx; 
    });
    int count;

    static class Element {
        Integer val;
        Integer idx;

        Element(Integer val, Integer idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Element)) return false;
            Element element = (Element) o;
            return idx.equals(element.idx);
        }

        @Override
        public int hashCode() {
            return idx.hashCode();
        }
    }

    public void insert(int value) {
        final Integer idx = count++;
        map.put(idx, value);
        maxHeap.offer(new Element(value, idx));
    }

    public void delete(Integer index) {
        if (map.containsKey(index)) {
            Element e = new Element(map.get(index), index);
            map.remove(index);
            // Only mark the element for deletion, lazy cleanup happens in getMax
            maxHeap.remove(e); 
        }
    }

    public Integer getMax() {
        while (!maxHeap.isEmpty()) {
            Element top = maxHeap.peek();
            if (!map.containsKey(top.idx)) {
                maxHeap.poll(); // Lazy removal of outdated entries
            } else {
                return top.val;
            }
        }
        return null; // Cache is empty
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}