import java.util.List;
import java.util.Random;
public class Node_3 {
    int key;   // Key value
    String val;  // Value or data for the node
    List<Node_3> list = null;    // The linked lists containing multiple nodes of next level(index)
}
class SkipL {
    private Node_3 head, tail;   /* front Sentinel and end sentinel */
    int maximumLevel;            /* Stores the Level for this skip list. Initially 0.*/
    Random r = new Random();     // For generating random level for node, using Java's utility class

    public static void main(String[] args) {
    }
}