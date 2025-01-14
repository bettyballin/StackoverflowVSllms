import java.lang.String;
public class DefaultHeapSize {
    public static void main(String[] args) {
        System.out.println("Initial Heap Size (Xms): " + Runtime.getRuntime().totalMemory() / 1024 + " KB");
        System.out.println("Maximum Heap Size (Xmx): " + Runtime.getRuntime().maxMemory() / 1024 + " KB");
    }
}