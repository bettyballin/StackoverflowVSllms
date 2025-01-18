import java.util.HashMap;

public class MyClass {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>(); // Creates HashMap
        map.put("key1", "value1");  // Adds key-value pairs to the map
        // ...

        boolean loadFactorExceeded = true;   // load factor: 0.7 - 1 (usually)

        if(loadFactorExceeded) {

            int oldCapacity = 16;              // The old capacity of HashMap
            int newCapacity = oldCapacity * 2; // Doubles the size on resizing

            MyNode[] arr = new MyNode[newCapacity]; // New bucket array with twice the number of buckets

            // Let's define 'table' as an array of MyNode
            MyNode[] table = new MyNode[oldCapacity];

            for (int i = 0; i < table.length; i++) { // Iterates through all existing elements
                if (table[i] != null) {              // Check to see if the hashmap contains value at this location
                    MyNode next = table[i];            // Start with the first node in the bucket
                    do {
                        int index = hash(next.key) & (newCapacity - 1); // Recompute original hash

                        MyNode old = arr[index];       // Points to the first node at bucket index

                        if (old != null) {           // Collision occurred
                            MyNode e = old.next;       // Assign reference to old's next node
                            MyNode n = new MyNode(next.key, next.value, e); // Create new node
                            arr[index] = n;          // Assign the newly created MyNode
                        } else {
                            // No collision
                            arr[index] = new MyNode(next.key, next.value); // Create a MyNode and add it to the array
                        }
                        next = next.next;
                    } while (next != null); // Go through entire list
                }
            }
        } else {
            /* Proceed if doubling not needed */
        }
    }

    // Simple hash function
    static int hash(Object key) {
        return (key == null) ? 0 : key.hashCode();
    }

    // Simple MyNode class
    static class MyNode {
        public Object key;
        public Object value;
        public MyNode next;

        MyNode(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        MyNode(Object key, Object value, MyNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}