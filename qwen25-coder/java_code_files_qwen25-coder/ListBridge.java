import java.util.List;

public class ListBridge {
    // Compiler-generated method inside Child class
    public void print(List list) {
        this.print((List<String>)list);
    }

    public void print(List<String> list) {
        // Original functionality preserved
    }

    public static void main(String[] args) {
    }
}