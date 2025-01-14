import java.lang.String;
// Example: Simple OT operation class
public class Operation {
    String type; // e.g., "insert", "delete"
    int index;
    String content;

    public Operation(String type, int index, String content) {
        this.type = type;
        this.index = index;
        this.content = content;
    }

    public static void main(String[] args) {
    }
}