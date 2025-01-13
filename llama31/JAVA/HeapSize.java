import java.lang.String;
public class HeapSize {
    public static void main(String[] args) {
        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Current heap size: " + heapSize);
    }
}