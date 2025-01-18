import java.lang.String;
public class Node_2 {
    class Node {     // An inner helper class that's used by Hashmap and Priority Queue both.
        private int value;      // The actual element inserted.
        private int index;       // Its original position in hash map. Order can differ after inserting equal values in max-heap property.

        public Node(int value, int index) {     // Constructor for creating Nodes representing elements with their order of entry to maintain max heap property.
            this.value = value;
            this.index = index;
        }

        // getters and setters can be added here if they are required based on needs. Like equals(), hashCode() etc.
    }

    public static void main(String[] args) {
    }
}